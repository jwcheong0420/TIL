def bfs():
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    visited = [[False] * _M for _ in range(_N)]
    bugNum = 0

    for i in range(_N):
        for j in range(_M):
            if _farm[i][j] == True and visited[i][j] == False:
                queue = [(i, j)]
                visited[i][j] = True

                while queue:
                    x, y = queue.pop(0)
                    for k in range(4):
                        tempX = x + dx[k]
                        tempY = y + dy[k]
                        if 0 > tempX or tempX >= _N or 0 > tempY or tempY >= _M:
                            # Pass if out of range
                            continue
                        elif _farm[tempX][tempY] == False:
                            # Pass if there's no lettuce
                            continue
                        elif visited[tempX][tempY] == True:
                            # Pass if visited
                            continue
                        else:
                            visited[tempX][tempY] = True
                            queue.append((tempX, tempY))

                bugNum = bugNum + 1

    return bugNum

if __name__ == "__main__":
    # Get testcase
    _T = int(input())
    bugNumList = []

    for _ in range(_T):
        # Get size of farm
        _M, _N, _K = map(int, input().split())
        _farm = [[False] * _M for _ in range(_N)]
        # Check lettuce
        for _ in range(_K):
            x, y = map(int, input().split())
            _farm[y][x] = True
        # bfs
        bugNumList.append(bfs())

    for i in bugNumList:
        print(i)
