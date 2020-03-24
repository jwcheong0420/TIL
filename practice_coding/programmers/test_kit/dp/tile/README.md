### 타일 장식물
https://programmers.co.kr/learn/courses/30/lessons/43104


#### 문제 요약
* 다음과 같은 타일 장식물이 있다
    * ![tile](tile.png)
* 이 장식물을 구성하는 타일의 정사각형 한 변의 길이를 처음부터 나열하면 다음과 같다
    * [1, 1, 2, 3, 5, 8, ...]
* 타일이 N개 있을 때 이 장식물의 둘레는?
    * N은 1 이상 80 이하
    * ex) N = 5일 때 둘레는 26


#### 문제 풀이 과정
* [1차 제출 코드](Solution1.java) - 성공
    * 타일 구성 자체는 피보나치
        * 계산상 편의를 위해 tiles 배열은 길이를 N + 1로 하고, N이 0일 때는 tiles[0] = 0
        * N이 1일 때, tiles[1] = 1
        * N이 2 이상일 때, tiles[N] = tiles[N - 2] + tiles[N - 1]
    * 둘레는 2 * (tiles[N - 1] + tiles[N]) + 2 * tiles[N] = 4 * tiles[N] + 2 * tiles[N - 1]
    * tiles 배열의 element type을 int가 아니라 long으로 해야함 주의!!!