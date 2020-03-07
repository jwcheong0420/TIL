## Problem
[Hash Tables: Ransom Note](https://www.hackerrank.com/challenges/ctci-ransom-note/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps)

## Notes
* 동일한 단어가 있는 경우 횟수도 중요하므로, note를 단어 단위로 for loop으로 돌 때 magazine에서 해당 단어를 지워줘야함
* 주어진 대로 list를 사용해서 magazine.remove(word)를 부르도록 짰더니 일부 testcase에 대해서 time exceeded로 실패함
    * note를 단어 단위로 for loop -> O(N)
    * remove()의 시간복잡도 O(N)
    * total O(N^2)여서 그랬던 것으로 보임
    * [코드](time-exceeded.py)
* 애초에 문제에 Hash Table이라고 명시되어있는데 바보같이 그냥 list로 풀었네...
    * list였던 magazine을 dictionary로 만들어서 key는 word고 value는 word가 나온 횟수를 저장했음
    * note를 단어 단위로 for loop -> O(N)
    * dictionary에 key로 access하는 경우 시간복잡도 O(1)
    * total O(N)으로 문제 통과
    * [코드](solution.py)


## Notes - 2차
* [Java로 다시 풀어보았다](Solution.java)