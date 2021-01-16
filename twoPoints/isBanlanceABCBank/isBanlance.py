#! -*- encoding: utf-8 -*-
import os
import sys
from typing import List
from collections import defaultdict



# 数组有6个数，是否可以分成相等的两组，让它们的和相同

def isBalance(nums: List[int]) -> int:

    sumNum = 0
    nums = sorted(nums)
    for x in nums:
        sumNum = sumNum + x
    target = sumNum / 2 - nums[0]
    i,j = 1,len(nums) - 1
    while i < j:
        tmp = nums[i] + nums[j]
        if tmp == target:
            return 1
        elif tmp < target:
            i = i + 1
        else:
            j = j - 1
    
    return 0


if __name__ == '__main__':
    
    nums = [1,3,3,4,2,1]

    print(isBalance(nums))



