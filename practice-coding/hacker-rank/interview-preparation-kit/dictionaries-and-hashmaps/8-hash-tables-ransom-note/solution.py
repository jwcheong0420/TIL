#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the checkMagazine function below.
def checkMagazine(magazine, note):
    hash_magazine = {}
    for word in magazine:   # O(N)
        if word in hash_magazine:
            hash_magazine[word] += 1    # O(1)
        else:
            hash_magazine[word] = 1    # O(1)

    for word in note:   # O(N)
        if word in hash_magazine and hash_magazine[word] > 0:
            hash_magazine[word] -= 1    # O(1)
        else:
            print("No")
            return
    # total : O(N)
    print("Yes")
    return

if __name__ == '__main__':
    mn = input().split()

    m = int(mn[0])

    n = int(mn[1])

    magazine = input().rstrip().split()

    note = input().rstrip().split()

    checkMagazine(magazine, note)
