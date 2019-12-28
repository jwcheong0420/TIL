## Problem
[Reverse a doubly linked list](https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists)

## Notes
* list를 전부 다 돌면서 current의 next와 prev를 swap, 만약 current의 next(새로운 prev)가 None인 경우 새로운 head이므로 저장했다가 리턴
* [코드](solution.py)
