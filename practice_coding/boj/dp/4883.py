k = 1   # Testcase number
# Get the number of the graph for the first testcase
N = int(input())

while(N != 0):
    # Initailize graph
    graph = [0, 0, 0] * N

    for i in range(N):
        # Fill the graph
        graph[i] = list(map(int, input().split()))

        # Caculate the cost
        # Remind that cost can be negative
        if i == 0:
            graph[0][2] += graph[0][1]  # From left
        elif i == 1:
            graph[1][0] += graph[0][1]  # From top-right
            graph[1][1] += min(graph[1][0], graph[0][1], graph[0][2])   # From left, top, top-right
            graph[1][2] += min(graph[1][1], graph[0][1], graph[0][2])   # From left, top-left, top
        else:
            graph[i][0] += min(graph[i-1][0], graph[i-1][1])    # From top, top-right
            graph[i][1] += min(graph[i][0], graph[i-1][0], graph[i-1][1], graph[i-1][2])    # From left, top-left, top, top-right
            graph[i][2] += min(graph[i][1], graph[i-1][1], graph[i-1][2])   # From left, top-left, top

    # Only need cost which of destination is graph[N-1][1]
    print(str(k) + ". " + str(graph[N-1][1])) 

    k += 1
    N = int(input())