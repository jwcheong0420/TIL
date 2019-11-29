import sys

# BFS function
def bfs():
    # up, down, left, right
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # Initialize distance array and queue
    distance = [[0] * _M for _ in range(_N)]
    distance[0][0] = 1
    queue = [(0, 0)]

    while queue:
        x, y = queue.pop(0)
        if x == _N-1 and y == _M-1:
            print(distance[_N-1][_M-1])
            return
        for i in range(4):  # up, down, left, right
            tempX = x + dx[i]
            tempY = y + dy[i]
            if tempX < 0 or tempY < 0 or tempX > _N-1 or tempY > _M-1:
                # Pass if out of range
                continue
            elif _maze[tempX][tempY] == '0':
                # Pass if wall
                continue
            elif distance[tempX][tempY] > 0:
                # Pass if already visited
                continue
            else:
                distance[tempX][tempY] = distance[x][y] + 1
                queue.append((tempX, tempY))

if __name__ == "__main__":
    # Get maze
    _N, _M = map(int, input().split())
    _maze = []
    for _ in range(_N):
        _maze.append(sys.stdin.readline())

    # Call BFS function
    bfs()