## Problem
[Flipping bits](https://www.hackerrank.com/challenges/flipping-bits/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous)

## Notes
* 처음엔 문제 그대로 integer를 32자리로 binary화 시켜서 하나씩 뒤집어야하나했는데 구글링하다보니 그냥 XOR bit 연산을 시키면 되는 일이었다
    * ^ : XOR 연산. 두 bit가 다른 값을 가질 때 참을 return
    * 4294967295(2^32 - 1)와 XOR 연산을 한 값이 곧 문제에서 말하는 bit를 flip한 결과이다
* [코드](solution.py)
