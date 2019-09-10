from collections import deque 

def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    while _ripened:
        x, y = _ripened.popleft()   # popleft() of deque is faster than pop(0) of list
        for i in range(4):
            tempX, tempY = x + dx[i], y + dy[i]
            if 0 <= tempX < _N and 0 <= tempY < _M and _boxes[tempX][tempY] == 0:
                _boxes[tempX][tempY] = _boxes[x][y] + 1
                _ripened.append((tempX, tempY))

def getAnswer():
    answer = 0
    for i in range(_N):
        if 0 in _boxes[i]:
            return -1
        else:
            answer = max(answer, max(_boxes[i]))
    return answer - 1

if __name__ == "__main__":
    _M, _N = map(int, input().split())
    _boxes = [[* map(int, input().split())] for _ in range(_N)]
    _ripened = deque()
    for i in range(_N):
        for j in range(_M):
            if _boxes[i][j] == 1:
                _ripened.append((i, j))

    bfs()
    print(getAnswer())