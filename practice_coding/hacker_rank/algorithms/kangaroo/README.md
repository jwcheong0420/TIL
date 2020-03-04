## Problem
[Kangaroo](https://www.hackerrank.com/challenges/kangaroo/problem)

## Notes
* [제출 코드](Solution.java)
    * 쉬운 문제임에도 불구하고 조건을 놓쳐서 빙빙 돌아왔다
        * 0 <= x1 < x2 <= 10000 조건을 놓침
        * 같은 차수에 같은 지점에 있어야하는데 크로스되면 그것도 만난다고 생각해버림
    * x1 < x2이기 때문에, v1 <= v2인 경우 1번 캥거루가 아예 역전도 못하므로 NO를 return하면 됨
    * double인 k가 정수임을 알려면, 소수점 이하를 올린 값(ceil)과 소수점 이하를 버린 값(floor)가 같은 지 확인하면 됨