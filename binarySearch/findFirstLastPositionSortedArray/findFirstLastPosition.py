#! -*- encoding: utf-8 -*-
import os
import sys
import math
from typing import List


def search(nums: List[int], target: int) -> List[int]:

    start = helper(nums, target)
    if start == len(nums) or nums[start] != target:
        return [-1, -1]
    return [start, helper(nums, target + 1) - 1]



def helper(nums, target):
    l, r = 0, len(nums)
    while l < r:
        mid = l + (r - l) // 2;
        if nums[mid] >= target:
            r = mid
        else:
            l = mid + 1
    return l
    
    

if __name__ == '__main__' :
    
    nums = [5, 7, 7, 8 , 8 , 10]
    res = search(nums, 8)
    print(res)


