### Bottom up ###

dp = [0 for i in range(12)]
dp[0] = 1
dp[1] = 1
dp[2] = 2

def fill_array():
    for i in range(3, 12):
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

# get T
T = int(input())

# fill array beforehand
fill_array()

# get array of n
num_list = []
for i in range(T):
    n = int(input())
    num_list.append(n)

for n in num_list:
    print(dp[n])