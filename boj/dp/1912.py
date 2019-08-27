# Get the number of nums
n = int(input())

# Get numbers
nums = list(map(int, input().split()))

# Initialize list
cache = [0] * n
cache[0] = nums[0]

# Sum
for i in range(1,n):
    if cache[i-1] + nums[i] > nums[i]:
        # Continuous sum is more advantageous
        cache[i] = cache[i-1] + nums[i]
    else:
        # It is better to start a new sum from itself
        cache[i] = nums[i]

# Get max sum
print(max(cache))