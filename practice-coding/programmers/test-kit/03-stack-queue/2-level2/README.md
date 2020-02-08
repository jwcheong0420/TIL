### 다리를 지나는 트럭
https://programmers.co.kr/learn/courses/30/lessons/42583

#### 문제 요약
* 트럭이 정해진 순서대로 다리를 건넘
* 다리는 길이가 bridge_length이고, weight의 무게를 견딜 수 있음
* 트럭의 무게는 truck_weights 배열
* 트럭은 다리를 1초에 1만큼 지나갈 수 있음
* 모든 트럭이 지나오는 데 드는 시간은?


#### 문제 풀이 과정
* 1차 - 통과
    * [1차 제출 코드](solution1.java)
        * 트럭 상태를 crossed, crossing, waiting으로 나누어서 생각해보았을 때, 셋 다 queue로 만들 필요가 없다.
            * waiting은 truck_weights의 인덱스를 증가시키면서 기억하면 되고
            * crossed는 굳이 관리할 이유가 없고, 마지막 트럭이 crossing이 되는 순간 answer(여태까지 걸린 시간) + bridge_length(길이가 n인 다리를 건너는 데에 n초가 걸리므로)이 곧 답이다.
            * crossing은 FIFO 특성이 강하고 무게의 합을 구할 때 Stream이 간편하므로 Queue로 선언하고 LinkedList로 구현했다.
        * **crossing.size()가 bridge_length와 같을 때만** crossing.poll()을 해야함 주의
* 2차 - 통과
    * [2차 제출 코드](solution2.java)
        * crossing.size() == bridge_length 여부를 while loop에서 계속 확인할 필요 없이,  
        while loop 들어가기 전에 **bridge_length만큼 crossing에 offer(0)**을 해놓으면 되는 일이었다.