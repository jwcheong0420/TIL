### Two Sum
https://leetcode.com/problems/two-sum/


#### 문제 요약
* nums 배열에서 두 수를 골라 그 합이 target이 되는 index를 배열로 리턴
    * ex. nums : [2, 7, 11, 15], target = 9일 때, 2와 7을 합하면 조건을 만족하므로 이의 index인 [0, 1]을 리턴
* 조건
    * 솔루션은 오직 하나
    * 같은 index의 수를 두 번 사용할 수 없음

#### 문제 풀이 과정
* [1차 제출 코드](Solution1.java) - 통과
    * 이중 for loop으로 했다... 가장 간단하지만 시간 복잡도가 O(n^2)이니까 마음에 들진 않는다.

* [2차 제출 코드](Solution2.java) - 통과
    * HashMap을 사용했다
    * nums를 for loop을 돌면서, target - nums[i]가 HashMap에 있는지 확인하고 없으면 nums[i]를 HashMap에 추가한다.
    * target - nums[i]가 HashMap에 있으면, 그 value와 i를 리턴