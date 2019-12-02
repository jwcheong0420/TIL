#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict

def make_hash(s):
    s_dict = defaultdict(int)
    for ch in s:
        s_dict[ch] += 1

    return s_dict

# Complete the makeAnagram function below.
def makeAnagram(a, b):
    a_dict = make_hash(a)
    b_dict = make_hash(b)

    for ch in a_dict.keys():
        while b_dict[ch] > 0 and a_dict[ch] > 0:
            a_dict[ch] -= 1
            b_dict[ch] -= 1

    return sum(a_dict.values()) + sum(b_dict.values())


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    a = input()

    b = input()

    res = makeAnagram(a, b)

    fptr.write(str(res) + '\n')

    fptr.close()
