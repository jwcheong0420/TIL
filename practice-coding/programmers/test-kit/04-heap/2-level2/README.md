### 라면공장
https://programmers.co.kr/learn/courses/30/lessons/42629

풀다가 중단... 다른 문제부터 풀자

#### 문제 요약
* 하루에 밀가루를 1톤씩 사용하는 공장
* 현재 남은 밀가루는 stock 톤
* dates[i] 일 후에 supplies[i] 톤의 밀가루를 공급받을 수 있다면
* 공장이 멈추는 날 없이 k일까지 버틸 수 있으려면 최소한 몇 번 공급받아야 하는가?
    * k-1일까지의 수량만 확보하면 됨


#### 문제 풀이 과정
* n차 - 성공
    * 오늘? 0일 째? 1일 후?의 늪에서 벗어나오는 데에 엄청나게 많은 에너지를 썼다...
        * 2, [1, 2, 3], [1, 1, 5], 4에 대한 답이 2가 아니라 1이라고 생각했던 나 자신 반성해
        * stock이 i일 때, 오늘(0일째)부터 i-1일째까지 다 써서 재고가 0이므로 공급일이 i일 후인 건을 꼭 받아야 함
    * [n차 제출 코드](solution1.java)
        * flourAmount는 stock을 포함하여 해외에서 공급받은 밀가루를 더한 총량이다
        * supplyQueue는 supply양을 내림차순으로 정렬하는 priority queue이다
        * flourAmount가 k 미만인 동안 다음 동작을 한다
            * 가진 flourAmount로는 남은 dates 중 언제까지 버틸 수 있는지 확인하고, 이에 해당하는 공급량을 supplyCandidates에 추가한다
            * supplyCandidates에서 가장 큰 공급량을 poll()하여 flourAmount에 더한다
            * answer(공급 횟수)++