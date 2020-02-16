## Problem
[Find Merge Point of Two Lists](https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists)

## Notes
* list1과 list2를 2중 while loop로 돌면서 object가 같은 것을 찾는다... 바보같은 방법인데 이것밖에 떠오르지 않았다
    * [코드](solution.py)
* 구글링하니까 다른 풀이가 나왔다 와 똑똑하다...
    * list1을 돌던 cur1과 list2를 돌던 cur2가 있을 때, cur1가 None에 도달하면 head2로 초기화해주고 cur2가 None에 도달하면 head1로 초기화해주어 while loop을 돌다보면 merge된 item에서 만나게 되어있다
    * 그러니까 list1의 길이 = a + c, list2의 길이 = b + c이고 공통 부분을 c라고 했을 때, 일단 쉽게 a > b인 상황을 가정해보면
        * b+c번째에 cur2가 head1에서부터 merge point까지의 남은 거리는 a
        * b+c번째에 cur1은 list의 끝까지 남은 거리는 a-b, head2에서 merge point까지 거리는 b이므로 총 a-b+b = a
        * b+c번째에 cur1과 cur2가 merge point까지 남은 거리가 a로 동일하다!
    * [코드](better-solution.py)
