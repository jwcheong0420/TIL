import sys
from heapq import heappush, heappop

def dijkstra():
    distance = [_INF] * (_V + 1)
    distance[_K] = 0
    priorityQueue = []
    heappush(priorityQueue, (0, _K))    # Min heap

    while priorityQueue:
        totalCost, currentV = heappop(priorityQueue)
        if distance[currentV] < totalCost:
            continue
        for nextV, weight in _graph[currentV]:
            tempCost = totalCost + weight
            if tempCost < distance[nextV]:
                distance[nextV] = tempCost
                heappush(priorityQueue, (tempCost, nextV))

    return distance

if __name__ == "__main__":
    # sys.stdin.readline() is faster than input()
    # https://www.acmicpc.net/board/view/855
    input = sys.stdin.readline

    _V, _E = map(int, input().split())
    _K = int(input())
    _INF = sys.maxsize

    # Adjacency list - Positive weighted directed graph
    _graph = [[] for _ in range(_V + 1)]
    for _ in range(_E):
        u, v, w = map(int, input().split())
        _graph[u].append((v, w))

    _answer = dijkstra()
    for answer in _answer[1:]:
        if answer == _INF:
            print("INF")
        else:
            print(answer)