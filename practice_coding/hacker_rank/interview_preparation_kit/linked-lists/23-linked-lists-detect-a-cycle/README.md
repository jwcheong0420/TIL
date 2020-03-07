## Problem
[Linked Lists: Detect a Cycle](https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists)

## Notes
* 방문 여부를 hash(python에서는 dictionary)에 추가하고, tail에 도달하기 전에 item이 이미 있는 경우 cycle이라고 판단하고 True를, 아니라면 False를 return하도록 했다
    * [코드](solution.py)
* 바보같은 것 같아서 구글링하니까 꽤 유명한 알고리즘이 있다 플로이드의 거북이와 토끼!
    * 토끼는 두 칸씩, 거북이는 한 칸씩 이동한다
        * 만약 cycle이 있다면 토끼는 반드시 거북이와 만난다
        * list의 tail에 도달할 때까지 토끼가 거북이를 만나지 않았다면 cycle이 없다
    * [코드](hare-and-tortoise.py)
    * cycle이 시작하는 위치를 알고 싶다면?
        * cycle이 시작하기 전까지의 길이를 m, cycle의 길이를 n이라고 하자
        * i번째에 cycle을 p바퀴 돈 토끼와 q바퀴 돈 거북이가 cycle 시작에서부터 k만큼 떨어진 곳에서 만났다
        * 토끼 : 2i = m + pn + k, 거북이 : i = m + qn + k
            * m + pn + k = 2m + 2qn + 2k
            * m + k = (p - 2q)n
        * 만난 시점에 토끼를(거북이어도 된다) 시작점으로 보내서 둘 다 이젠 한 칸씩만 (m + k)만큼 이동시킨다
            * 이 때 (m + k)는 (p - 2q)n, 즉 cycle의 길이의 배수이다
            * 시작점부터 출발한 토끼와 cycle에 있던 거북이가 (m + k) 위치에서 다시 만난다는 결론이 난다
            * 이 때 둘 다 한 칸씩 이동하므로, cycle 시작 지점부터 같이 이동해왔다는 것을 알 수 있다
        * 따라서 시작점으로 토끼를 옮긴 후 한 칸씩 가게하여 거북이와 최초로 만난 지점이 cycle의 시작 지점이다
    
