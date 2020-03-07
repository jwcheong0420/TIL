## Problem
[Fibonacci Modified](https://www.hackerrank.com/challenges/fibonacci-modified/problem)

## Notes
* [1차 제출 코드](Solution1.java)
    * 연산 결과가 64bit가 넘어갈 수 있으므로 long으로도 안되고 BigInteger를 사용해야 한다
        * BigInteger는 연산할 때 method(add, multiply 등)을 사용해야 함 주의
* [2차 제출 코드](Solution2.java)
    * 배열을 만들어서 저장해두면 중복 계산을 덜하니까 조금 빠르다