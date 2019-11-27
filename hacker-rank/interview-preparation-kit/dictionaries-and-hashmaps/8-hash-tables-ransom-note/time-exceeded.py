#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the checkMagazine function below.
def checkMagazine(magazine, note):
    for word in note:   # O(N)
        if word in magazine:
            magazine.remove(word) # O(N)
        else:
            print("No")
            return
    # total : O(N^2) -> time exceeds
    print("Yes")
    return

if __name__ == '__main__':
    mn = input().split()

    m = int(mn[0])

    n = int(mn[1])

    magazine = input().rstrip().split()

    note = input().rstrip().split()

    checkMagazine(magazine, note)
