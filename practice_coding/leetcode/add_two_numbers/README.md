### Add Two Numbers
https://leetcode.com/problems/add-two-numbers/


#### 문제 요약
* 두 개의 음이 아닌 정수를 나타내는 linked list가 있다
* 각 node는 single digit를 갖고 있음
* 각 linked list는 수를 reverse order로 갖고 있다
    * ex. 342를 표현하는 linked list는 2 -> 4 -> 3으로 구성됨
* 두 수를 더한 결과를 linked list로 표현하라

#### 문제 풀이 과정
* [1차 제출 코드](Solution1.java) - 실패
    * list 각각을 수로 변환한 후에 더해서 list로 만들고자 했음
    * int로 하면 범위를 초과하는 경우가 있더라... long으로 해도 마찬가지였고, 한 자리씩 더해가야겠구나라는 생각이 들었다

* [2차 제출 코드](Solution2.java) - 성공
    * l1.next와 l2.next 둘 다 null이 될 때까지 while loop을 돌면서 한 자리씩 더한다
    * 그 합이 10이 초과하면 up이라는 boolean flag를 true로 바꾼다
    * 좀 코드가 지저분하다... solution을 열어보고 아뿔싸 싶었다

* [3차 제출 코드](Solution3.java) - 성공
    * while 조건을 l1.next와 l2.next가 아니라 l1와 l2로 하고, 맨 처음에 dummy head를 만들어서 실제 리턴할 때는 dummy head의 next를 리턴하면 while loop안에서 다 해결 가능하다...
    * 그리고 carry라는 아주 좋은 단어가 있었고, boolean으로 따로 세팅할 필요 없이 sum/10을 저장하면 될 일이었다