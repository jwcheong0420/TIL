# time exceeded

# recursive
N = int(input())

def f(X):
    if X == 1:
        return 0
    elif X == 2 or X == 3 :
        return 1
    else :
        tmp_count = [None, None, None]
        if X%3 == 0:
            tmp_count[0] = f(X/3)
        if X%2 == 0:
            tmp_count[1] = f(X/2)
        tmp_count[2] = f(X-1)

        return 1 + min(i for i in tmp_count if i is not None)

print(f(N))