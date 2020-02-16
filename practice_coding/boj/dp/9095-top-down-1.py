### Top down ###

# recursive function
# f(n) = f(n-1) + f(n-2) + f(n-3) (if n > 3)
def f(n):
    if n == 1:
        return 1
    elif n == 2:
        return 2
    elif n == 3:
        return 4
    else:
        return f(n-1)+f(n-2)+f(n-3)

# f2(n) also can be used for solution
def f2(n):
    if n < 0:
        return 0
    elif n <= 1:
        return 1
    else:
        return f2(n-1)+f2(n-2)+f2(n-3)

# get T
T = int(input())

# get array of n
num_list = []
for i in range(T):
    n = int(input())
    num_list.append(n)

for n in num_list:
    print(f(n))