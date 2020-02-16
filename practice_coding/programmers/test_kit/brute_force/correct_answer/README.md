### 모의고사
https://programmers.co.kr/learn/courses/30/lessons/42840


#### 문제 요약
* 각 학생이 문제의 답을 찍는 패턴은 아래와 같음
    * 1번 : 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ... (1, 2, 3, 4, 5 반복)
    * 2번 : 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, ... (2, n 반복이고 n은 순차적으로 1, 3, 4, 5 반복)
    * 3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ... (3, 1, 2, 4, 5를 두 번씩 반복)
* 문제의 답 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람은?


#### 문제 풀이 과정
* 1차 - 통과
    * [1차 제출 코드](solution1.java)
        * Student라는 class를 만들어서 ArrayList로 관리
            * constructor에서 id와 int 가변인자 submitted를 받는다
                * ex) Student(1, 1, 2, 3, 4, 5)은 id는 1이고 답의 패턴은 1, 2, 3, 4, 5인 학생을 의미한다
            * correctAnswer(number, answer)는 number번째 문제에 대한 정답이 answer일 때 학생이 제출한 답이 정답이면 hit++
            * Comparable을 implement하여 나중에 Collections.sort()를 사용할 때 hit 내림차순으로 정렬되도록 함
        * ArrayList<Integer> highest에는 최고득점자의 id를 넣는다
            * Collections.sort(students) 결과, hit 내림차순으로 정렬되므로, students.get(0).getId()를 highest에 일단 추가
            * for loop을 돌면서 i번째 학생의 hit와 (i + 1)번째 학생의 hit을 비교하여 같으면 (i + 1)번째 학생의 id도 추가
            * id를 내림차순으로 정렬해야하므로, Collections.sort(highest)
            * return 시 highest를 array로 변환한다
    * 통과는 했고 나의 생각의 흐름대로 최대한 확장성있게 짜려했지만, 굳이 이렇게 풀 필요는 없을 것 같다.
        * 가변 인자 받을 때 id랑 답이랑 헷갈리는 것도 가독성에 좋지 않은 것 같고
        * 굳이 정렬을 두 번이나 해야하는 것도 걸림