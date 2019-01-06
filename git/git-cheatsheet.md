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