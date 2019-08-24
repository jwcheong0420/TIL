# Get the number of wine
n = int(input())

if n != 1:
    wine = [0] * n
    drink = [0] * (n+1)

    # Get the amount of wine
    for i in range(n):
        wine[i] = int(input())

    # Calculate the amount of wine that hyoju drank
    for i in range(n+1):
        if i == 0:
            # For 3rd trial
            drink[0] = 0
        elif i == 1:
            drink[1] = wine[0]
        elif i == 2:
            drink[2] = wine[0] + wine[1]
        else:
            # There are three options
            # 1. Don't drink this turn
            # 2. Didn't drink in i-1 turn, drink this turn
            # 3. Didn't drink in i-2 turn, drink i-1 and this turn
            drink[i] = max(drink[i-1], drink[i-2] + wine[i-1], drink[i-3] + wine[i-2] + wine[i-1])

    print(drink[n])

else:
    print(input())



