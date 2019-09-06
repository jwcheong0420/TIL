def bfs(rainHeight):
    dx = [-1, 1, 0 ,0]
    dy = [0, 0, -1, 1]
    visited = [[False] * _N for _ in range(_N)]
    safeAreaNum = 0
    for i in range(_N):
        for j in range(_N):
            if visited[i][j] == False and _map[i][j] > rainHeight:
                visited[i][j] = True
                queue = [(i, j)]

                while(queue):
                    x, y = queue.pop(0)
                    for k in range(4):
                        tempX = x + dx[k]
                        tempY = y + dy[k]
                        if tempX < 0 or tempX >= _N or tempY < 0 or tempY >= _N:
                            # Pass if out of range
                            continue
                        elif _map[tempX][tempY] <= rainHeight:
                            # Pass if sunk
                            continue
                        elif visited[tempX][tempY] == True:
                            # Pass if visited
                            continue
                        else:
                            queue.append((tempX, tempY))
                            visited[tempX][tempY] = True

                safeAreaNum = safeAreaNum + 1
    return safeAreaNum

if __name__ == "__main__":
    _N = int(input())
    _map = []
    _maxHeight = 0
    for _ in range(_N):
        tmpList = list(map(int, input().split()))
        _maxHeight = max(_maxHeight, max(tmpList))
        _map.append(tmpList)

    _safeArea = [1] # if it didn't rain
    for i in range(1, _maxHeight):
        _safeArea.append(bfs(i))
    print(max(_safeArea))