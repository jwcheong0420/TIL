# Little bit difficult

from collections import deque

def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    distance = [[[-1] * 2 for _ in range(_M)] for _ in range(_N)]
    distance[0][0][0] = 1
    queue = deque()
    queue.append((0, 0, 0))

    while queue:
        x, y, w = queue.popleft()
        for i in range(4):
            tempX, tempY = x + dx[i], y + dy[i]
            if 0 <= tempX < _N and 0 <= tempY < _M and distance[tempX][tempY][w] == -1:
                if _maze[tempX][tempY] == '0':
                    queue.append((tempX, tempY, w))
                    distance[tempX][tempY][w] = distance[x][y][w] + 1
                elif w == 0:
                    # Crash the wall
                    queue.append((tempX, tempY, 1))
                    distance[tempX][tempY][1] = distance[x][y][0] + 1

    if distance[_lastX][_lastY][0] == -1:
        return distance[_lastX][_lastY][1]
    elif distance[_lastX][_lastY][1] == -1:
        return distance[_lastX][_lastY][0]
    else:
        return min(distance[_lastX][_lastY])

if __name__ == "__main__":
    _N, _M = map(int, input().split())
    _maze = [list(input()) for _ in range(_N)]
    _lastX, _lastY = _N - 1, _M - 1

    print(bfs())