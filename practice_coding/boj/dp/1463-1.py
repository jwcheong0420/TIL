### success but it takes too long
N = int(input())

min_count = [0 for i in range(N+1)]

for X in range(1, N+1):
    if X == 1:
        min_count[X] = 0
    else:
        min_count[X] = 1 + min_count[X-1]
        if X%3 == 0:
            tmp_count = 1 + min_count[X//3]
            min_count[X] = min(tmp_count, min_count[X])
        if X%2 == 0:
            tmp_count = 1 + min_count[X//2]
            min_count[X] = min(tmp_count, min_count[X])

print(min_count[N])