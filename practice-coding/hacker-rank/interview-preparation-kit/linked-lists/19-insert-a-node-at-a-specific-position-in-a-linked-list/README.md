## Problem
[Insert a node at a specific position in a linked list](https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists)

## Notes
* position이 0인 경우는 list의 head로 insert하고 싶다는 의미이므로 새로운node.next = head로 하고 새로운node를 return
* 그 외의 경우 position-1만큼 next하고 새로운node를 끼워넣은 후 head를 return
* [코드](solution.py)
