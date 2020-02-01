### 베스트 앨범

#### 문제 요약
* genres[i]은 고유번호 i의 장르
* plays[i]는 고유번호 i의 재생 횟수
* 재생 횟수가 가장 많은 장르부터 튼다
    * 장르별 재생 횟수는 다르다
* 장르 별로 2곡씩 틀고, 1곡 뿐이면 1곡만 튼다
    * 장르 중 재생 횟수가 가장 많은 곡부터 튼다
    * 같은 장르 내에서 재생 횟수가 같다면 고유번호가 낮은 곡부터 튼다


#### 문제 풀이 과정
* 1차 - 정확도 테스트 통과(효율성 테스트 없음)
    * [1차 제출 코드](solution1.java)
        * genre를 key로 하고, Song(id와 재생횟수를 저장)의 ArrayList를 value로 하는 HashMap을 만든다
            * Song 대신에 Entry<Integer, Integer>로 해도 되긴 하지만 너무 더러워서...
        * play 합이 많은 genre 순으로 HashMap을 정렬하기 위해 ArrayList로 변환하고,  
        Comparator로 play수의 합이 많은 순대로 1차 정렬
        * genre 우선순위 순서대로, ArrayList<Song>를 Comparator로 play 수와 id 순으로 2차 정렬 및 상위 2개를 answerList에 추가
        * int[]로 return해야하므로 stream을 이용하여 ArrayList를 int[]로 변환
    * 정말이지 너무 더럽다. 이 방법밖에 없는가? Song을 만든 김에 Comparator 말고 Comparable을 사용해볼까?
* 2차 - 정확도 테스트 통과(효율성 테스트 없음)
    * [2차 제출 코드](solution2.java)
        * Comparable을 구현하는 Song(id, play을 멤버로 가짐)과,  
        마찬가지로 Comparable을 구현하는 Genre(ArrayList<Song>을 멤버로 가짐) class를 만든다
        * HashMap<String, Genre>로 genre별 Genre 인스턴스에 노래 정보를 넣고
        * Genre별 sort 진행 후 Song별 sort 진행
        * genre별 최대 상위 2개까지 answer ArrayList에 추가
        * int[]로 return해야하므로 stream을 이용하여 ArrayList를 int[]로 변환
    * 자료 구조를 두 개를 만들고 Comparator가 아니라 Comparable을 사용했는데, 아예 자료 구조를 하나만 만들고 stream으로 구현한 능력자도 있더라...
* 3차 - 정확도 테스트 통과(효율성 테스트 없음)
    * [3차 제출 코드](solution3.java)
        * Stream은 아직도 잘 모르겠다...
        * 코드 길이는 짧지만, 막상 실행 시간은 더 길다. 그냥 이렇게도 짤 수 있다 정도만 알아두면 될 것 같다.
            * 소요 시간 비교 : 2차 6ms 대, 3차 19ms 대