#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the luckBalance function below.
def luckBalance(k, contests):
    max_luck = sum([i[0] for i in contests])

    lucks_important = [i[0] for i in contests if i[1] == 1]
    lucks_important.sort(reverse=True)

    need_to_decrease = sum(lucks_important[k:])

    return max_luck - need_to_decrease * 2


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    nk = input().split()

    n = int(nk[0])

    k = int(nk[1])

    contests = []

    for _ in range(n):
        contests.append(list(map(int, input().rstrip().split())))

    result = luckBalance(k, contests)

    fptr.write(str(result) + '\n')

    fptr.close()
