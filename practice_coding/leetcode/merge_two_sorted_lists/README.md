### Merge Two Sorted Lists
https://leetcode.com/problems/merge-two-sorted-lists/


#### 문제 요약
* 두 개의 sorted list를 합해서 하나의 sorted list를 리턴

#### 문제 풀이 과정
* [1차 제출 코드](Solution1.java) - 성공했으나 너무 1차원적인 풀이
    * while loop 돌면서 다음과 같은 조건으로 새로운 list를 만든다
        * l1가 null이면 l2를 merge하고 l2을 next로 넘김
        * l2가 null이면 l1을 merge하고 l1을 next로 넘김
        * l1.val < l2.val이면 l1을 merge하고 l1을 next로 넘김
        * 그 외에는 l2를 merge하고 l2를 next로 넘김

* [2차 제출 코드](Solution2.java) - 성공
    * while loop에서는 둘 다 null이 아닌 경우에 대해서만 처리
    * while loop 후에 둘 중에 null이 아닌 걸 그 뒤에 붙임

* [3차 제출 코드](Solution3.java) - Recursion이라서 시간도 더 소요되고 공간도 더 많이 씀
    * Discussion을 보니까 Recursion 풀이가 있길래 시도
    * l1이 null이면 l2를 리턴, l2가 null이면 l1을 리턴
    * l1.val < l2.val이면 l1.next를 mergeTwoLists(l1.next, l2)를 호출해서 recursive하게 구하고 l1을 리턴
    * 그 반대면 l2.next를 mergeTwoLists(l1, l2.next)를 호출해서 recursive하게 구하고 l2를 리턴