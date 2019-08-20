### Top down ###
advanced_fib = {0:1, 1:0}

def fib(n):
    if n == 0:
        return 1
    elif n == 1:
        return 0
    elif n in advanced_fib:
        return advanced_fib[n]
    else:
        advanced_fib[n] = fib(n-1) + fib(n-2)
        return advanced_fib[n]

T = int(input())
num = []
for i in range(T):
    num.append(int(input()))

for i in num:
    print(fib(i), fib(i+1))