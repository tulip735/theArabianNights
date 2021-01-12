#! -*- encoding: utf-8 -*-
import os
import sys
from typing import List
from collections import defaultdict



# You are given a sorted array consisting of only integers where every element appears exactly twice,
# except for one element which appears exactly once.
# Find this single element that appears only once.
# Follow up: Your solution should run in O(log n) time and O(1) space.

# Example 1:
# Input: nums = [1,1,2,3,3,4,4,8,8]
# Output: 2

# Example 2:
# Input: nums = [3,3,7,7,10,11,11]
# Output: 10


def singleNonDuplicate(nums: List[int]) -> int:

    if len(nums) == 1:
        return nums[0]
    l, r = 0, len(nums) - 1
    if nums[l] != nums[l + 1]:
        return nums[l]
    if nums[r] != nums[r - 1]:
        return nums[r]

    while l <= r:
        mid = l + (r - l) // 2
        # mid 为奇数位置
        # print(mid)
        if mid % 2 == 0:
            if nums[mid] == nums[mid - 1]:
                r = mid - 2
            elif nums[mid] == nums[mid + 1]:
                l = mid + 2
            else:
                return nums[mid]
        if mid % 2 == 1:
            if nums[mid] == nums[mid - 1]:
                l = mid + 1
            elif nums[mid] == nums[mid + 1]:
                r = mid - 1
            else:
                return nums[mid]
    return -1
                


if __name__ == '__main__':

    # nums = [1,1,2,3,3,4,4,8,8]
    # nums = [1,1,2,3,3,4,4]
    nums = [1,2,2]
    res = singleNonDuplicate(nums)
    print(res)
    








    
