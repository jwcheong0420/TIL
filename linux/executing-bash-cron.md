# cron으로 bash script 실행시키기
reboot할 때마다 script를 실행시킬 일이 생겨서 cron을 사용하게 되었는데, 삽질을 하면서 알게된 내용을 기술하고자 한다.
여러 가지가 엮여있는 내용이라 좀 장황하므로, 맨 마지막 결론만 읽어도 무방하다.

## cron
cron은 crontab에 예약된 작업을 반복적으로 실행시키는 데몬이다.
cron은 ubuntu 기본 패키지이므로 별도의 설치과정이 필요없다.
다음의 명령어를 입력하여 작업을 등록할 수 있다.
```bash
$ crontab -e
```

작업을 등록할 때는 실행될 주기, 실행하고자하는 명령어나 파일을 적으면 된다.
reboot할 때마다 /root/cron/test.sh를 실행하고 싶다면 아래와 같이 작업을 등록한다.
```bash
@reboot /root/cron/test.sh > /root/work/cron/cron.log 2>&1
```
매번 껐다 켤 수 없으므로 테스트할 때는 매분 실행되도록 하였다.
```bash
* * * * * /root/cron/test.sh > /root/work/cron/cron.log 2>&1
```
*은 every의 의미로, 맨 왼쪽부터 '분 시간 일 월 년'을 의미한다.

### 문제가 되었던 cron test 과정
문제는 여기에서 발생했다.
테스트 코드가 매우 복잡했던 관계로 대략적인 뼈대만 적자면, bash script 안에서 flock으로 또 다른 명령어들을 실행하는 구조였다.
```bash
#!/bin/bash
if [[ -d /path/to/lock/dir ]];then
    flock -x -o /path/to/lock/file -c 'if [[ /test/something ]]; then echo "blah"; fi;'
fi
```
다음과 같은 에러가 발생했다.
```bash
/bin/sh: 1: /bin/sh: [[: not found
```
/bin/bash로 실행하라고 shebang(#!/bin/bash)을 넣었음에도 /bin/sh로 실행되었다는 것에 의문을 품게 되었다.

## cron은 default shell로 작업을 실행시킨다
수차례 테스트한 결론부터 말하자면, cron은 default shell 즉, $SHELL -c '등록된 작업'을 실행시킨다.
이 때 $SHELL은 기본적으로 /bin/sh이다.
이는 비단 cron뿐 아니라 flock도 그런 것으로 보이는데, 아래의 테스트 결과에서 알 수 있다.
```bash
#!/bin/bash
flock -x -o /root/work/cron/lock -c 'ps -ajxf | grep -C3 cron'
```
cron이 위 스크립트를 실행하게 한 결과는 다음과 같다.(불필요한 라인은 삭제했다.)
```bash
root@dev:~/work/flock# vi qcreate_shell-nonshebang.log
    1   892   892   892 ?           -1 Ss       0   0:00 /usr/sbin/cron -f
  892  4018   892   892 ?           -1 S        0   0:00  \_ /usr/sbin/CRON -f
 4018  4019  4019  4019 ?           -1 Ss       0   0:00      \_ /bin/sh -c ~/work/cron/test.sh >> ~/work/cron/test.log 2>&1
 4019  4020  4019  4019 ?           -1 S        0   0:00          \_ /bin/bash /root/work/cron/test.sh
 4020  4021  4019  4019 ?           -1 S        0   0:00              \_ flock -x -o /root/work/cron/lock -c ps -ajxf | grep -C3 cron
 4021  4022  4019  4019 ?           -1 S        0   0:00                  \_ /bin/sh -c ps -ajxf | grep -C3 cron
 4022  4023  4019  4019 ?           -1 R        0   0:00                      \_ ps -ajxf
 4022  4024  4019  4019 ?           -1 S        0   0:00                      \_ grep -C3 cron
```
우선 cron은 /bin/sh -c '명령'으로 실행시킨다.
/bin/sh은 -c의 인자로 온 '명령'을 새로운 프로세스를 띄워서 실행시키며, 이 때 shebang을 인식하여 알맞는 shell로 실행시킨다.
flock 역시 /bin/sh -c '명령'으로 실행시키는 것을 알 수 있다.

이젠 crontab에 SHELL을 /bin/bash로 등록한 뒤, 똑같은 작업을 수행해보았다.
```bash
$ crontab -e
SHELL=/bin/bash
* * * * * /root/cron/test.sh >> /root/cron/test.log 2>&1
```
아래는 실행 결과다.(역시 불필요한 라인은 삭제했다.)
```bash
    1   892   892   892 ?           -1 Ss       0   0:00 /usr/sbin/cron -f
  892  4099   892   892 ?           -1 S        0   0:00  \_ /usr/sbin/CRON -f
 4099  4100  4100  4100 ?           -1 Ss       0   0:00      \_ /bin/bash -c ~/work/cron/test.sh >> ~/work/cron/test.log 2>&1
 4100  4101  4100  4100 ?           -1 S        0   0:00          \_ /bin/bash /root/work/cron/test.sh 
 4101  4102  4100  4100 ?           -1 S        0   0:00              \_ flock -x -o /root/work/cron/lock -c ps -ajxf | grep -C3 cron
 4102  4103  4100  4100 ?           -1 S        0   0:00                  \_ /bin/bash -c ps -ajxf | grep -C3 cron
 4103  4104  4100  4100 ?           -1 R        0   0:00                      \_ ps -ajxf
 4103  4105  4100  4100 ?           -1 S        0   0:00                      \_ grep -C3 cron
```
cron도 flock도 -c 다음에 오는 명령을 이번에는 /bin/bash로 실행시켰다!
 
## ubuntu의 default shell
똑같은 스크립트를 필자가 실행했을 때와 cron이 실행했을 때 결과가 달랐던 것은, 결국 실행하는 shell이 달랐기 때문이었다.

ubuntu의 경우 default shell이 /bin/sh이며, 별다른 수정을 하지 않았다면 dash(bourne shell)를 가리킨다.
```bash
root@dev:~/# ll /bin/sh
lrwxrwxrwx 1 root root 4  4월 10 14:43 /bin/sh -> dash*
```
그렇기 때문에 테스트 과정에서 cron과 flock은 ubuntu의 default shell인 /bin/sh로 명령어를 실행한 것이다.
이 때 /bin/sh -c '명령어'는 '명령어'를 실행하기 위해 새로운 프로세스를 띄우며, loader가 shebang을 확인한다.
(필자는 굳이 flock -c의 인자로 스크립트 내용을 줌으로써 삽질을 했던 것이었다.
처음부터 flock -c '#!/bin/bash가 추가된 스크립트 파일'을 실행하게 했으면 겪지 않았을 문제였다...!)

반면 user의 default login shell이 bash이기 때문에, 필자는 shebang을 추가하지 않고도 bash로 스크립트를 실행할 수 있었던 것이다.
```bash
root@dev:~/work/flock# cat /etc/passwd
root:x:0:0:root:/root:/bin/bash
```

## 결론
돌고 돌아왔으나, 이번 테스트로 함축되는 내용은 다음 네 가지이다.
1. ubuntu의 default shell은 /bin/sh이며, 이는 dash를 가리킨다.
2. 스크립트를 실행하면 loader가 맨 첫 줄의 shebang을 보고 알맞은 shell을 실행시킨다.
3. user의 default login shell은 /bin/bash이다.
4. cron으로 bash script를 실행하고 싶다면, 스크립트에 shebang을 추가하거나 crontab에 SHELL=/bin/bash를 추가해야 한다.(이는 cron을 떠나서 추가해주는 것이 ~~정신건강에~~ 좋다.)