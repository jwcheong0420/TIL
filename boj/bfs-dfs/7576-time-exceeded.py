def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    while _ripened:
        x, y = _ripened.pop(0)
        for i in range(4):
            tempX = x + dx[i]
            tempY = y + dy[i]
            if tempX < 0 or tempX >= _N or tempY < 0 or tempY >= _M:
                # Pass if it is out of range
                continue
            elif _boxes[tempX][tempY] != 0:
                # Pass if it is wall or already ripened
                continue
            else:
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
    _boxes = []
    _ripened = []
    for i in range(_N):
        _boxes.append(list(map(int, input().split())))
        for j in range(_M):
            if _boxes[i][j] == 1:
                _ripened.append((i, j))

    bfs()
    print(getAnswer())