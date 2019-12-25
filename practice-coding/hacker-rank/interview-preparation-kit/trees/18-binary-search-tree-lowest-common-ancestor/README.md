## Problem
[Binary Search Tree : Lowest Common Ancestor](https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees)

## Notes
* v1과 v2가 root를 기점으로 모두 왼쪽에 있으면 root.left로, 모두 오른쪽에 있으면 root.right로 lca를 recursive하게 호출
* v1과 v2가 양쪽에 나뉘어 있거나, root.info가 v1 혹은 v2이거나 등의 다른 상황일 때는 root가 바로 lowest common ancestor
* [코드](solution.py)
