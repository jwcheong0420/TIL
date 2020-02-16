### K번째 수
https://programmers.co.kr/learn/courses/30/lessons/42748

#### 문제 요약
* 배열에서 i번째부터 j번째의 수를 오름차순으로 정렬하여 k번째에 있는 수를 구하라

#### 문제 풀이 과정
* [1차 제출 코드](Solution1.java) - 정확성 테스트(효율성 테스트 없음)
    * Arrays.copyOfRange()를 사용해서 배열의 일부를 copy
    * copy한 배열을 Arrays.sort()로 오름차순으로 정렬
    * 인덱스가 commands[i][2] - 1인 수를 answer[i]에 추가