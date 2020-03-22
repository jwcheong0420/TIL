### 큰 수 만들기
https://programmers.co.kr/learn/courses/30/lessons/42883


#### 문제 요약
* number에서 k개의 숫자를 제거해서 만들 수 있는 가장 큰 수를 구하라
    * ex) 1924에서 2개의 숫자를 제거
        * 만들 수 있는 수 : 19, 12, 14, 92, 94, 24
        * 가장 큰 수 : 94
    * 순서는 바꿀 수 없음 주의


#### 문제 풀이 과정
* [1차 제출 코드](Solution1.java) - 12개 중 2개 통과, 8개 실패, 2개 시간 초과
    * number를 num[]으로 변환
        * 매번 number.charAt(i) - '0'하는 것은 번거로우니까 처음에 다 해준다
    * 시작할 숫자를 고른다
        * 인덱스가 0 ~ k인 수 중에서 맨 처음 나온 가장 큰 수를 골라서 answer에 추가 : answer += num[index]
        * 추가된 수 이전에 버린 수 카운트 : count = index
        * index는 이미 포함되었으므로 다음 고려 대상에서 제외 : index++
    * 그 뒤로 뺄 수를 고른다 : count가 k보다 작은 동안 while loop
        * 인덱스가 index ~ index + k - count && index < len인 수 중에서 맨 처음 나온 가장 작은 수는 뺀다
            * min을 구하고 min_index를 구함
        * answer에 min_index 이전의 숫자들을 포함시킴
        * index = min_index + 1로 while loop 다시 시작
    * 남은 수를 더한다
        * count만큼 뺀 뒤 남은 숫자들을 더함

* [2차 제출 코드](Solution2.java) - 성공
    * 맨 처음 나온 min을 빼는 게 아니라 맨 나중에 나온 min부터 빼야함
        * 1차 제출코드대로 하면 99991에서 2개를 뺀다고 쳤을 때 답이 991로 나올 것임 정답은 999인데 말이지
        * 그리고 다른 분 풀이를 봤는데 Stack을 사용하셨더라... 이만큼 적합한 자료구조가 없다... 아직 난 멀었어ㅠㅠ
    * number 한 자리씩 for loop
        * !stack.isEmpty() && stack.peek() < number.charAt(i) && count < k일 때
            * stack.pop()
            * ex. count가 0 이고 k가 4인 상황에서, stack에 [4, 1]이 있고 다음 수가 7이라면, stack이 빌 때까지 pop
        * stack.push(number.charAt(i))
    * stack.size() == number.length() - k 만족할 때까지 pop
        * stack.size() < number.length() - k인 케이스는 없음. count >= k일 때 pop을 수행하지 않기 때문.
