#! -*- encoding: utf-8 -*-
import os
import sys
from typing import List
from collections import defaultdict
import math





def search(nums: List[int], target: int) -> int:

    l, r = 0, len(nums) -1

    while l <= r:
        # mid = floor(l + (r - l) / 2)
        # Math.Floor, which rounds down towards negative infinity.
        # Math.Ceiling, which rounds up towards positive infinity.
        # Math.Truncate, which rounds up or down towards zero.
        # python3 -3/2 = 1.5      
        # python3 -3//2 = -2     
        # python3 math.floor(-3/2) = -2     
        # python3 math.trunc(-3/2) = -1     
        
        mid = (l +  math.trunc((r - l) // 2)
        print(mid)
        if target == nums[mid]:
            return mid

        if nums[l] <= nums[mid]:
            if target >= nums[l] and target < nums[mid]:
                r = mid - 1
            else:
                l = mid + 1
        else:
            if target > nums[mid] and target <= nums[r]:
                l = mid + 1
            else:
                r = mid - 1
        return -1
    


if '__main__' == __name__:

    nums = [4,5,6,7,8,9,0,1,2,3]

    result = search(nums, 0)
    print(result)


    



