# Unable to resolve host 발생 시 대처 방법
ubuntu에서 sudo를 사용할 때마다 다음과 같은 문구가 뜨는 경우가 있다.
```bash
sudo: unable to resolve host
```
명령을 실행하는 데에 문제가 되는 것 같지는 않지만 매우 거슬리므로 해결해보도록 하자.

## hostname
hostname은 네트워크에 연결된 장치에 부여되는 고유한 이름이다.

ubuntu desktop 버전을 설치할 때 user를 생성하다보면 계정명과 pc이름처럼 이상한 것이 결합되어 길게 hostname이 붙곤 한다.
이 hostname은 terminal의 명령행에 계속 노출되므로 길면 거슬리기 마련이라, 필자는 보통 dev로 변경하는 편이다.

## /etc/hostname과 /etc/hosts
ubuntu의 hostname을 변경하려면 총 두 개의 파일을 수정해야한다.
결론부터 말하자면 unable to resolve host 문구가 출력되었던 이유는 이 두 파일의 내용이 달랐기 때문이었다.

에러가 발생하는 상황에서 두 파일을 비교해보면 다음과 같다.
```bash
$ cat /etc/hostname
dev
$ cat /etc/hosts
127.0.0.1   localhost
127.0.1.1   jwcheong-15U530-GH5HK
#(이하 생략)
```

/etc/hostname에는 dev라고 나와있는 반면, /etc/hosts에는 변경 전의 hostname이 쓰여있었다.
예전에 hostname을 바꿀 때 /etc/hostname만 변경한 모양이다.
~~계정 생성 단계에서 바꿨으면 쉬웠 읍읍~~

/etc/hosts에서 예전 hostname을 지우고 현재 hostname으로 변경해주면 더 이상 문구가 출력되지 않는다.
```bash
$ vi /etc/hosts
127.0.0.1   localhost
127.0.1.1   dev
#(이하 생략)
```