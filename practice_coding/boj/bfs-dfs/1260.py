### Adjacency list ###

# DFS(Depth First Search)
def dfs(graph, now):
    check[now] = True
    DFS.append(str(now))
    for v in graph[now]:
        if check[v] is False:
            dfs(graph, v)

# BFS(Breadth First Search)
def bfs(graph, start):
    queue = [start]
    check = [False] * (N + 1)
    check[start] = True

    while queue:
        vertex = queue.pop(0)
        BFS.append(str(vertex))
        for v in graph[vertex]:
            if check[v] is False:
                queue.append(v)
                check[v] = True

# Get the number of vertexes, edges and starting point
N, M, V = map(int, input().split())
graph = [[] for _ in range(N + 1)]  # Use _(underscore) for throw-away
check = [False] * (N + 1) # Avoid duplicated visits

# Get edges
for _ in range(M):
    srcVertex, destVertex = map(int, input().split())
    graph[srcVertex].append(destVertex)
    graph[destVertex].append(srcVertex)

# Sort graph
## Cannot use set because it needs to be sorted
for i in range(N):
    graph[i].sort()

BFS = []
DFS = []

dfs(graph, V)
bfs(graph, V)

print(" ".join(DFS))
print(" ".join(BFS))