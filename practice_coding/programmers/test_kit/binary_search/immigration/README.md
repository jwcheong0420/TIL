### 입국심사
https://programmers.co.kr/learn/courses/30/lessons/43238


#### 문제 요약
* n명의 승객이 있고, 심사관별로 입국심사에 times[]만큼 시간이 걸린다
* 최소 시간을 구하기 위해, 승객은 본인 차례에서 다른 직원이 끝나길 기다렸다가 받을 수 있다
    * ex) 마지막 승객이 10분짜리 직원이 비었지만 1분만 더 기다려서 7분짜리 직원에게 받으면 더 빨리 받을 수 있다
* n은 1명 이상 1,000,000,000명 이하
* times[]에 들어갈 값(입국심사에 걸리는 시간)은 1분 이상 1,000,000,000분 이하
* 심사관은 1명 이상 100,000명 이하

#### 문제 풀이 과정
* [1차 제출 코드](Solution1.java) - 통과
    * 실패의 실패를 거듭한 끝에 통과했다...222
    * 로직
        * int를 전부 long으로 바꾼다
            * n과 times[] 값의 범위가 어마무시하다... long으로 캐스팅해주지 않으면 몇몇 테스트 케이스에서 실패를 맛볼지니...
        * long으로 캐스팅한 times를 정렬한다
            * binary search는 정렬된 배열에 대해서 사용해야 한다
            * Arrays.sort(Tim Sort)에 대한 시간 복잡도 : O(n log n)
            * binary search에 대한 시간 복잡도 : O(log n)
        * 1과 max(times) * n 사이의 answer를 binary search로 찾아보자
            * left <= right일 때 while loop
            * mid = (left + right) / 2일 때, mid만큼의 시간동안 각 직원이 심사할 수 있는 최대 승객의 수를 다 더한다(tmpN)
            * tmpN이 n보다 작으면 시간을 더 줘야하므로, left = mid + 1로 다시 계산
            * tmpN이 n보다 크거나 같으면 시간을 덜 줘도 되므로, right = mid - 1로 다시 계산
                * 이 때 anwser에 현재 mid와 answer 중 더 작은 것을 저장