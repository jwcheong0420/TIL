N = int(input())
min_count = {1:0}

def f(X):
    if X not in min_count:
        if X%6 == 0:
            min_count[X] = 1 + min(f(X//3), f(X//2))
        elif X%3 == 0:
            min_count[X] = 1 + min(f(X//3), f(X-1))
        elif X%2 == 0:
            min_count[X] = 1 + min(f(X//2), f(X-1))
        else:
            min_count[X] = 1 + f(X-1)
    return min_count[X]

print(f(N))