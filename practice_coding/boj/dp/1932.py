# Get the number of layers of the triagle
n = int(input())

# Define the array of sum
sum_list = []

for i in range(n):
    # Get numbers that make up the triangle
    # 1. Split input with whitespace
    # 2. Apply int() to each numbers
    # 3. Convert the map object to list
    sum_list.append(list(map(int, input().split())))
    for j in range(i+1):
        if i == 0:
            break
        elif j == 0:
            # Get sum of the leftmost
            sum_list[i][j] += sum_list[i-1][j]
        elif j == i:
            # Get sum of the rightmost
            sum_list[i][j] += sum_list[i-1][j-1]
        else:
            sum_list[i][j] += max(sum_list[i-1][j-1], sum_list[i-1][j])

print(max(sum_list[n-1]))