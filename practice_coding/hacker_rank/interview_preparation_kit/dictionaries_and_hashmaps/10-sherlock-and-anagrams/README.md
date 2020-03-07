## Problem
[Sherlock and Anagrams](https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps)

## Notes
* Anagram : 단어나 문장을 구성하는 문자의 순서를 바꿔서 새로운 단어나 문장을 만드는 놀이
    * ex) rail safety = fairy tales

* 길이가 1 ~ (len(s) - 1)인 substring끼리 비교하여 그 substring을 구성하는 문자 종류와 그 개수가 같으면 anagram이다
    * 길이가 1 ~ (len(s) - 1) -> O(N)
        * 가능한 substring 모두 구하기 -> O(N)
        * substring을 구성하는 문자 종류를 key, 개수를 value로 하는 dictionary list를 만드는 작업 -> O(N)
            * substring에서 2쌍을 뽑아 비교하기 위한 작업 -> O(N^2)
    * total O(N^4)로 timeout 발생해서 실패
    * [코드](timeout.py)

* 무엇을 최적화할 수 있을까 곰곰이 생각해봤는데, substring을 hash로 만들고 그걸 비교하는 부분이 너무 복잡하다는 느낌
    * 길이가 1 ~ (len(s) - 1) -> O(N)
        * substring의 list를 만들 때 아예 substring을 sort시켜서 append시키면 substring을 쪼개서 비교하지 않아도 string 비교로 가능
            * substring의 list를 돌면서(O(N)) sort(O(NlogN)) -> O(N^2*logN)
        * 정렬된 substring에 대한 hash를 만들고, 그 개수 중에 2개를 뽑는 조합을 계산하면?
            * hash 만드는 건 O(N)
            * hash의 key를 돌면서(O(N)) nC2 계산(python3 기준 factorial은 O(NlogN)) -> O(N^2logN)
                * nCr = math.factorial(n) / (math.factorial(n-r) * math.factorial(r))인데
                * python2와는 달리 python3에서는 math.factorial()을 divide and conquer로 구현하여 빠름
                    * [Why is math.factorial much slower in Python 2.x than 3.x?](https://stackoverflow.com/questions/9815252/why-is-math-factorial-much-slower-in-python-2-x-than-3-x)
    * total O(N^3*logN)
    * [코드](solution.py)