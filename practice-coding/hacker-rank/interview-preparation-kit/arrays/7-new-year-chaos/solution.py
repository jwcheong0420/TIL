#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumBribes function below.
def minimumBribes(q):
    count = 0
    for idx, val in enumerate(q):
        if val - (idx + 1) > 2:
            print("Too chaotic")
            return

        # Count the number of bribes that 'val' should receive
        for j in range(max(0, val - 2), idx):
            if q[j] > val:
                count += 1

    print(str(count))
    return

if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        n = int(input())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
