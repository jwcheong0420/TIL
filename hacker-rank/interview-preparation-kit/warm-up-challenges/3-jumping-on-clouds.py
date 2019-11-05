#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the jumpingOnClouds function below.
def jumpingOnClouds(c):
    notes = [0 for _ in range(len(c))]
    current = 0
    dest = len(c) - 1
    while dest > current:
        if c[current] == 0:
            if dest - current >= 2:
                if c[current + 2] == 0 and notes[current + 2] == 0:
                    notes[current + 2] = notes[current] + 1
                if c[current + 1] == 0 and notes[current + 1] == 0:
                    notes[current + 1] = notes[current] + 1
            else:
                if notes[dest] == 0:
                    notes[dest] = notes[current] + 1
        current += 1
    return notes[dest]

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input())

    c = list(map(int, input().rstrip().split()))

    result = jumpingOnClouds(c)

    fptr.write(str(result) + '\n')

    fptr.close()
