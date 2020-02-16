# Get the number of wine
n = int(input())

wine = []
drink = []
# Get the amount of wine
for i in range(n):
    wine.append(int(input()))

# Calculate the amount of wine that hyoju drank
for i in range(n+1):
    if i == 0:
        # For 3rd trial
        drink.append(0)
    elif i == 1:
        drink.append(wine[0])
    elif i == 2:
        drink.append(wine[0] + wine[1])
    else:
        # There are three options
        # 1. Don't drink this turn
        # 2. Didn't drink in i-1 turn, drink this turn
        # 3. Didn't drink in i-2 turn, drink i-1 and this turn
        drink.append(max(drink[i-1], drink[i-2] + wine[i-1], drink[i-3] + wine[i-2] + wine[i-1]))

print(drink[n])