### Top K Frequent Elements
https://leetcode.com/problems/top-k-frequent-elements/


#### 문제 요약
* array에 중복된 숫자들이 있다
* 가장 중복이 많이 된 k개의 숫자를 리턴하라
* 조건
    * k는 1 이상 array 중 중복되지 않은 수의 개수 이하
    * array의 길이가 n일 때 시간 복잡도가 O(n log n)보다 좋아야 함


#### 문제 풀이 과정
* [1차 제출 코드](Solution1.java) - 성공했으나 시간도 공간도 별로 좋지 않음
    * 중복된 개수를 구하는 부분 - HashMap 사용
    * 개수를 토대로 정렬하는 부분 - Comparable을 구현한 Number라는 object를 정의해서 TreeSet으로 정렬
        * 이 때 중복된 수가 같을 경우 0으로 리턴하면 TreeSet도 중복 원소로 처리되므로, 숫자도 비교해주도록 한다
    * k번만큼 TreeSet의 pollFirst()를 호출

* [2차 제출 코드](Solution2.java) - 1차보다는 시간은 좋으나 공간은 비슷함
    * TreeSet이 아니라 PriorityQueue로 해서, compareTo() 구현할 때 count만 고려
        * 0으로 리턴해도 pq에 원소로 다 추가됨

* [3차 제출 코드](Solution3.java) - Solution인데ㅋㅋㅋㅋ 시간, 공간 복잡도는 비슷하넼ㅋㅋㅋ
    * 바보같이... object를 굳이 정의하지 않더라도 compare할 때 이미 만들어둔 HashMap을 이용하는 방법이 있었다...

* [4차 제출 코드](Solution4.java) - Discussion에 나온 bucket sort 사용했는데 시간 복잡도만 조금 줄었음
    * pq 대신에 List의 배열을 정의해서, 배열 index를 frequency로 정하는 방법