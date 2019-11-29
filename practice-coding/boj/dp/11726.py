dp = [0 for i in range(1001)]
dp[0] = 1
dp[1] = 1

def count():
    for i in range(2, 1001):
        if dp[i] == 0:
            dp[i] = (dp[i-1] + dp[i-2])%10007

count()
n = int(input())
print(dp[n])