#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the sherlockAndAnagrams function below.
def sherlockAndAnagrams(s):
    count = 0
    for length in range(1, len(s)):
        substring_list = []
        for i in range(len(s) - length + 1):
            substring_list.append("".join(sorted(s[i:i+length])))

        substring_hash = {}
        for sub in substring_list:
            if sub in substring_hash:
                substring_hash[sub] += 1
            else:
                substring_hash[sub] = 1

        for nums in substring_hash.values():
            if nums > 1:
                count += math.factorial(nums) / (math.factorial(nums - 2) * math.factorial(2))

    return int(count)

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        s = input()

        result = sherlockAndAnagrams(s)

        fptr.write(str(result) + '\n')

    fptr.close()
