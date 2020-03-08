## Problem
[Big Sorting](https://www.hackerrank.com/challenges/big-sorting/problem)

## Notes
* [1차 제출 코드 - 시간 초과 4개](Solution1.java)
    * String 배열 -> BigInteger 배열로 변환 및 정렬 -> String 배열
    * 역시나 시간 초과로 몇몇 테스트 케이스들 실패
* [2차 제출 코드 - 시간 초과 1개](Solution2.java)
    * 정수를 문자열로 변환하는 과정이 좀 오래걸린다는 소리를 듣고... Comparator를 사용해서 최대한 줄여보았다
        * 자리 수가 같을 경우에만 BigInteger로 변환해서 비교
        * 자리 수가 다르면 무조건 긴 것이 큼
    * 그래도 하나 실패함
        * 아... 생각해보니 변환할 필요없이 자리 수가 같으면 그냥 String 크기 비교를 했어도 되는구나...!
* [3차 제출 코드 - 시간 초과 1개 동일](Solution3.java)
    * 아 뭔데...? testcase 열어보자
        * https://hr-testcases-us-east-1.s3.amazonaws.com/33593/input06.txt?AWSAccessKeyId=AKIAJ4WZFDFQTZRGO3QA&Expires=1583654772&Signature=ZfKwZ0SY%2Ft9xtasdz%2FNuuV5JAs8%3D&response-content-type=text%2Fplain
        * 수가 엄청엄청 많다는 것만 알겠다...
* [4차 제출 코드](Solution4.java)
    * Scanner를 쓰지 말고 BufferedReader를 쓰라는 선구자들의 지혜를 수용해서 통과ㅠㅠ
        * https://www.hackerrank.com/challenges/big-sorting/forum/comments/586554
