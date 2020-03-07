#!/bin/python3

import math
import os
import random
import re
import sys

def generate_hash(s):
    s_hash = {}
    for ch in s:
        if ch in s_hash:
            s_hash[ch] += 1
        else:
            s_hash[ch] = 1

    return s_hash

def compare_substrings(s1, s2):
    if s1 == s2:
        return True
    else:
        s1_hash = generate_hash(s1)
        s2_hash = generate_hash(s2)
        if s1_hash == s2_hash:
            return True
        else:
            return False

# Complete the sherlockAndAnagrams function below.
def sherlockAndAnagrams(s):
    count = 0
    for length in range(1, len(s)):
        substring_list = []
        for i in range(len(s) - length + 1):
            substring_list.append(s[i:i+length])

        for i1, s1 in enumerate(substring_list):
            for i2, s2 in enumerate(substring_list):
                if i1 != i2:
                    if compare_substrings(s1, s2):
                        count += 1
    return int(count/2)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        s = input()

        result = sherlockAndAnagrams(s)

        fptr.write(str(result) + '\n')

    fptr.close()
