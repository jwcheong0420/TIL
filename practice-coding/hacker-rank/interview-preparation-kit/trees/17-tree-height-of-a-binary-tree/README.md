## Problem
[Tree: Height of a Binary Tree](https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees)

## Notes
* 정의 되어있는 Node의 level property를 사용해볼까 했는데, height()을 recursive하게 만들어버리면 굳이 필요없다
* return할 때마다 +1해서 depth를 표현한다
    * root node만 있는 경우의 return 값이 0이 되도록 하기 위해서, height(None)의 return 값은 -1로 정한다
    * [코드](solution.py)