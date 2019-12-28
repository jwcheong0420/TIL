## Problem
[Inserting a Node Into a Sorted Doubly Linked List](https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists)

## Notes
* list의 맨 앞에 끼워넣을 경우와 그 외 경우로 나누어 해결
    * 맨 앞에 끼워넣을 경우 list를 while로 돌 필요 없이 head와 새로운 node의 next, prev 관계만 정리하여 새로운 node를 리턴
    * 그 외의 경우 list를 while로 돌면서 next가 존재하지 않거나(tail 뒤에 넣는 경우) node의 data가 새로운 node의 data보다 큰(현재 node와 next node 사이에 끼워넣을 경우) 상황에서 next, prev를 정리하고 head를 그대로 리턴
* [코드](solution.py)
