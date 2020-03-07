#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumAbsoluteDifference function below.
def minimumAbsoluteDifference(arr):
    min_diff = sys.maxsize
    n = len(arr)
    for x in range(n):
        for y in range(x+1, n):
            if arr[x] >= arr[y]:
                temp_min_diff = arr[x] - arr[y]
            else:
                temp_min_diff = arr[x] - arr[y]
            min_diff = min(min_diff, abs(temp_min_diff))

    return min_diff


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    arr = list(map(int, input().rstrip().split()))

    result = minimumAbsoluteDifference(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
