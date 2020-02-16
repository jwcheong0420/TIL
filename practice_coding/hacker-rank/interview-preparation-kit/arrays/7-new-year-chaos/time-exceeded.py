#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the minimumBribes function below.
def minimumBribes(q):
    for idx, val in enumerate(q):
        if val - (idx + 1) > 2:
            print("Too chaotic")
            return

    count = 0
    for i in range(len(q)):
        for j in range(i + 1, len(q)):
            if q[i] > q[j]:
                temp = q[i]
                q[i] = q[j]
                q[j] = temp
                count += 1
            
    print(str(count))
    return

if __name__ == '__main__':
    t = int(input())

    for t_itr in range(t):
        n = int(input())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
