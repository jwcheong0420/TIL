### 타겟 넘버
https://programmers.co.kr/learn/courses/30/lessons/43165


#### 문제 요약
* n개의 음이 아닌 정수를 적절하게 더하거나 빼서 원하는 수를 만들 수 있는 가지 수를 구하라


#### 문제 풀이 과정
* 1차 - 통과
    * [1차 제출 코드](solution1.java)
        * numbers랑 target number를 재귀함수의 인자로 몽땅 넣었고, 배열 중 몇 번째 element를 더해야하는지 index도 넘기고, 여태까지의 합도 넘겨서 풀었다
        * dfs를 너무 오랜만에 풀어봐서 한참 걸렸다... 게다가 answer를 전역 변수로 만들어 버리는 바보같은...(말잇못)
            * dfs의 return 값을 0 혹은 1로 해서 더해버리면 되는 거였는데...

* 2차 - 통과
    * [2차 제출 코드](solution2.java)
        * 재귀함수의 return을 index가 numbers의 length와 같으면 0 혹은 1, 다르면 합 재귀 + 빼기 재귀