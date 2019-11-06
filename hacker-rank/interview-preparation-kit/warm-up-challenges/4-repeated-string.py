#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the repeatedString function below.
def repeatedString(s, n):
    index = []
    for i in range(len(s)):
        if s[i] == 'a':
            index.append(i)

    nums = (n // len(s)) * len(index)
    modulo = n % len(s)

    for i in range(len(index) - 1, -1, -1):
        if index[i] < modulo:
            nums += (i + 1)
            break

    return nums

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = input()

    n = int(input())

    result = repeatedString(s, n)

    fptr.write(str(result) + '\n')

    fptr.close()
