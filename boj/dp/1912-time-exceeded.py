# Get the number of nums
n = int(input())

# Get numbers
nums = list(map(int, input().split()))

# Initialize list
sums = [0] * n
sums[0] = nums

# Sum
for i in range(1,n):
    # Initialize elem of the list
    elem = [0] * (n - i)
    for j in range(n - i):
        for k in range(j, j + i + 1):
            elem[j] += nums[k]
    sums[i] = elem

# Get max sum
print(max(map(max, sums)))