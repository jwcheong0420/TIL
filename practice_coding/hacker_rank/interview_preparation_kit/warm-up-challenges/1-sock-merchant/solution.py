#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the sockMerchant function below.
def sockMerchant(n, ar):
    nums = {}
    for socks in ar:
        if socks in nums:
            nums[socks] += 1
        else:
            nums[socks] = 1

    pairs = sum(list(map(lambda p : p//2, nums.values())))
    return pairs

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    ar = list(map(int, input().rstrip().split()))

    result = sockMerchant(n, ar)

    fptr.write(str(result) + '\n')

    fptr.close()
