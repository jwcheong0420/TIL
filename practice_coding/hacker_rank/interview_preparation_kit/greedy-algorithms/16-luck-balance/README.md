## Problem
[Luck Balance](https://www.hackerrank.com/challenges/luck-balance/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms)

## Notes
* L[i]는 contest당 luck의 양, T[i]는 contest가 중요하면 1이고 안중요하면 0, k는 져도 되는 횟수
    * ex. 총 6개의 contest 중 T[i]가 4개일 때 k가 3이라면, 중요한 contest 중 1개는 반드시 이겨야 함

* 이겼을 경우 L[i]을 차감, 질 경우 L[i]을 더함
    * 일단 모든 luck을 더하고, 이겼을 경우에 대한 luck을 2번 빼주는 게 간편할 듯

* max luck을 구하는 것이므로 L[i]이 적은 contest를 지는 게 이득이지!
    * 그렇다면 T[i]가 1인 contest를 따로 모아서 sort해준다
        * 이 때 오름차순 정렬이면, sum(important_contests[:len(important_contests) - k]) 응 귀차나
        * 내림차순 정렬이면, sum(important_contests[k:]) 굳!

* 와 단번에 통과한 문제는 너가 처음이야...[코드](solution.py)