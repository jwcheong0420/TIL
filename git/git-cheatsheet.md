# Git Cheatsheet

알게 된 git 기능 정리

### git ignore
Mac인 경우에 .DS_Store 파일이 git의 untracked file로 남는다.
git에 올려도 문제는 없겠지만, 올릴 필요가 없는 파일이므로 .gitignore파일을 이용하여 무시하도록 설정해보자.
```bash
joowon>~/work/hobby$ vi .gitignore
.DS_Store 추가

joowon>~/work/hobby$ git add .gitignore
joowon>~/work/hobby$ git commit
joowon>~/work/hobby$ git push origin master
```
참고 사이트 : [git ignore generator](https://www.gitignore.io/)

### git remote url 설정
git repo 주소가 바뀐 경우 push할 때 아래와 같은 경고 문구가 뜬다.
```bash
joowon>~/work/hobby$ git push origin master
Counting objects: 3, done.
Delta compression using up to 4 threads.
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 339 bytes | 339.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0)
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
remote: This repository moved. Please use the new location:
remote:   https://github.com/jwcheong0420/TIL.git
To https://github.com/jwcheong0420/hobby.git
   37c30f5..8f2af37  master -> master
```
현재 local에 설정되어있는 repo 주소를 확인해보자
```bash
joowon>~/work/hobby$ git remote -v
origin	https://github.com/jwcheong0420/hobby.git (fetch)
origin	https://github.com/jwcheong0420/hobby.git (push)
```
이제 맞는 repo 주소로 바꾼 뒤에 확인해보자
```bash
joowon>~/work/hobby$ git remote set-url origin https://github.com/jwcheong0420/TIL.git
joowon>~/work/hobby$ git remote -v
origin	https://github.com/jwcheong0420/TIL.git (fetch)
origin	https://github.com/jwcheong0420/TIL.git (push)
```

### git remote branch 상황을 local에 update하기
local에서 git branch -a를 했을 때 이미 remote에서 지워진 branch임에도 불구하고 목록에 나오는 경우가 있다.
아래의 command를 사용하여 remote 상황을 local에 update해보자.
```bash
joowon>~/work/hobby$ git remote update origin --prune
```

### git merge와 rebase의 차이
다음과 같은 상황이 있다고 하자.
commit1이 있는 test-master(master로 가정) 브랜치에서 test-dev(dev로 가정) 브랜치가 갈라져나왔다.
dev에서 commit2를 남겼고, 누군가가 master에서 commit3을 남겼다.
```bash
joowon>~/work/hobby/git$ git log --all
commit 5b45681692dc8b05179cbb9de73611cb597b179e (HEAD -> test-master)
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 06:15:20 2019 +0900

    commit 3 at master

commit efd35f764063e40d869cef5138f70d9337516669 (test-dev)
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 06:14:51 2019 +0900

    commit 2 at dev

commit 77aa3ade86ee944dafe6c137f69a336b50eeb7b2
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 05:51:58 2019 +0900

    commit 1 at master

```
dev에서는 주기적으로 master의 최신 commit을 반영해주는 것이 좋다.(자주 안 해줘서 나중에 conflict 나면 골치 아파진다.)
이 때 rebase를 사용할 수도 있고, merge를 사용할 수도 있다.
1. merge를 사용하는 경우
```bash
joowon>~/work/hobby/git$ git checkout test-dev
joowon>~/work/hobby/git$ git merge test-master
joowon>~/work/hobby/git$ git log --all
commit 6fcf203ad4b82e1c5157665feceff433fee0b759 (HEAD -> test-dev)
Merge: efd35f7 5b45681
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 06:23:00 2019 +0900

    Merge branch 'test-master' into test-dev

commit 5b45681692dc8b05179cbb9de73611cb597b179e (test-master)
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 06:15:20 2019 +0900

    commit 3 at master

commit efd35f764063e40d869cef5138f70d9337516669
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 06:14:51 2019 +0900

    commit 2 at dev

commit 77aa3ade86ee944dafe6c137f69a336b50eeb7b2
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 05:51:58 2019 +0900

    commit 1 at master

```
commit 1,2,3 외에 6fcf2 hash값을 갖는 merge commit이 하나 더 생기면서 합쳐졌다.

2. rebase를 사용하는 경우
```bash
joowon>~/work/hobby/git$ git checkout test-dev
joowon>~/work/hobby/git git rebase test-master
joowon>~/work/hobby/git$ git log --all
commit 53338f0b219177e0d6747b4341e4d6707c44618c (HEAD -> test-dev)
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 06:14:51 2019 +0900

    commit 2 at dev

commit 5b45681692dc8b05179cbb9de73611cb597b179e (test-master)
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 06:15:20 2019 +0900

    commit 3 at master

commit 77aa3ade86ee944dafe6c137f69a336b50eeb7b2
Author: Joowon Cheong <jwcheong0420@gmail.com>
Date:   Mon May 20 05:51:58 2019 +0900

    commit 1 at master

```
commit 2의 hash값이 efd35에서 53338로 바뀌며 commit이 재정렬되었고, merge commit 같은 추가적인 commit이 생기지 않는다.

개인적으로는 이 케이스에서는 rebase를 사용하고 있다.
dev와 master의 동기화라는 측면에서는 merge보단 재정렬의 의미가 더 맞다고 생각하기 때문이다.
merge는 dev를 master로 합칠 때처럼 두 브랜치를 합친다라는 의미가 더 강하다.

그리고 rebase를 할 때 방향을 헷갈리지 않도록 주의해야 한다.
재정렬되는 대상 브랜치의 commit들의 hash값이 바뀌기 때문에 방향을 헷갈렸다간 conflict가 날 수도 있다.

### 여담1) git bash 사용 시 branch 이름의 대소문자 구분하지 않음 주의
git 차원에서는 구분되나 git bash(MINGW64)에서는 구분되지 않았다... 주의하자
