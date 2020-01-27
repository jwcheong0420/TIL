## 완주하지 못한 선수

### 문제 요약
* 마라톤 참가자 중 1명만 완주하지 못했다고 할 때, 그 선수의 이름을 출력하라
* 유의할 제한 사항
    * 참가자 배열(participant)의 길이는 완주자 배열(completion)의 길이보다 1 큼
    * 참가자 중 동명이인이 존재할 수 있음

### 문제 풀이 과정
* 1차 - 정확도 & 효율성 테스트 통과
    * participant와 completion을 비교해서 다른 것 하나만 비교하면 된다고 단순하게 생각했음
        * 생각해보니 hash를 사용해서 풀라는 거였는데...
    * [1차 제출 코드](solution1.java)
        * participant와 completion을 sort
        * completion을 기준으로 for loop을 돌리고 participant랑 비교해서 다른 element 발생하면 그걸 answer로 간주
        * for loop을 다 돌았음에도 answer가 empty string인 경우 participant의 마지막 element가 answer
        * 시간 복잡도 : O(n log n)
            * Arrays.sort()가 O(n log n)이므로
    * 미흡했던 점
        * hash를 사용해서 풀라던 출제의도를 간과함
        * for loop 부분이 더러움
* 2차 - 정확도 & 효율성 테스트 통과
    * 1차에서 더러운 for loop만 정리한 버전
    * [2차 제출 코드](solution2.java)
* 3차 - 정확도 & 효율성 테스트 통과
    * [3차 제출 코드](solution3.java)
        * participant를 기준으로 HashMap을 만들고
        * completion을 기준으로 HashMap에서 뺀다
        * HashMap에 value가 0이 아닌 key가 바로 answer
        * 시간 복잡도 : O(n)
            * participant for loop, completion for loop, hashMap iteration에 의해