import sys

def bfs(startX, startY):
    # up, down, left, right
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # Initialize queue
    queue = [(startX, startY)]
    _visited[startX][startY] = True
    count = 1

    while queue:
        x, y = queue.pop(0)
        for i in range(4):
            tempX = x + dx[i]
            tempY = y + dy[i]
            if tempX < 0 or tempY < 0 or tempX > _N-1 or tempY > _N-1:
                # Pass if out of range
                continue
            elif _map[tempX][tempY] == '0':
                # Pass if house doesn't exist
                continue
            elif _visited[tempX][tempY] == True:
                # Pass if visited house
                continue
            else:
                _visited[tempX][tempY] = True
                count = count + 1
                queue.append((tempX, tempY))

    return count

if __name__ == "__main__":
    # Get map
    _N = int(input())
    _map = []
    for _ in range(_N):
        _map.append(sys.stdin.readline())

    # Initialize visited and vilage list
    _visited = [[False] * _N for _ in range(_N)]
    _vilage = []

    # Find starting point
    for i in range(_N):
        for j in range(_N):
            if _map[i][j] == '1' and _visited[i][j] == False:
                _vilage.append(bfs(i, j))

    _vilage.sort()
    print(len(_vilage))
    for i in _vilage:
        print(i)