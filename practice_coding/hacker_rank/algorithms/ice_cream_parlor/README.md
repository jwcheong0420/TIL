## Problem
[Ice Cream Parlor](https://www.hackerrank.com/challenges/icecream-parlor/problem)

## Notes
* [1차 제출 코드](Solution1.java)
    * 가격을 key로 하고 맛을 value로 하는 hash table을 만들면 되겠네, 라고 생각했는데 가격이 중복되는 경우가 있어서 일단은 이중 for문으로 풀었음
* [2차 제출 코드](Solution2.java)
    * 문제 분류가 Binary Search길래 어떻게든 그렇게 풀어보려고 Comparable을 구현하는 IceCream class도 만들어보고 별 짓을 다했는데, 너무 복잡했다
    * 사람들은 왜 hash table로 이 문제는 푸는가? 했는데, 생각해보니 hash table에 남은 가격에 해당하는 아이스크림이 있는지를 확인해가면서 table에 넣으면 알아서 걸러진다.
        * 만약 현재 차례의 가격이 이미 hash table에 있는데, 이 두 개를 골라야 정답이다.
            * hash table에 있는 것이 index가 더 작으므로 hash table에 있는 것 먼저, 그 다음은 현재 index 값을 넣은 배열을 return
        * 만약 현재 차례의 가격이 이미 hash table에 있지만, 이 두 개를 골라도 정답이 아니다.
            * hash table에 있는 것이 index가 더 작으므로, 정답을 발견했을 때 현재 차례의 index를 사용할 일이 없다. 그러므로 hash table에 넣을 때 기존 값을 유지함.
