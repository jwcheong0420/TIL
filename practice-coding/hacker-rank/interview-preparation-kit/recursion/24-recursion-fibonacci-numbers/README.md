## Problem
[Recursion: Fibonacci Numbers](https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=recursion-backtracking)

## Notes
* 간단하게는 문제 그대로 recursive하게 짜면 됨
    * [코드](solution.py)
* n의 길이가 한정적이므로, 한 번 계산되었던 값은 list로 저장해뒀다가 불러오는 방식을 사용하면, 동일 계산 횟수를 줄여서 실행 속도를 빠르게 할 수 있다
    * [memoization](memoization.py)
    * Dynamic Programming(동적 계획법)의 핵심
        * [BOJ에서 풀었던 DP 문제들](/practice-coding/boj/dp)
