fib = [-1 for _ in range(31)]

def fibonacci(n):
    if fib[n] == -1:
        if n == 0 or n == 1:
            fib[n] = n
        else:
            fib[n] = fibonacci(n-2) + fibonacci(n-1)

    return fib[n]

n = int(input())
print(fibonacci(n))

