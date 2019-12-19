## Problem
[Minimum Absolute Difference in an Array](https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms)

## Notes
* 배열에 속한 수들의 차이의 절대값 중 가장 작은 값을 구하는 문제
    * 모든 조합이라고 생각 못하고 인접한 것들만 구하는 줄 알고 헷갈림

* 모든 조합 구하기... 2중 for문은 역시나 timeout이 발생한다
    * [코드](timeout.py)

* 생각해보니 모든 조합을 구할 필요가 없었다. 미리 정렬하면 될 것을...!
    * python에서 list의 sort의 복잡도는 O(N log N)
    * 인접한 수만큼만 돌면 되므로 조합을 만드는 복잡도는 O(N)
    * [코드](solution.py)