#! -*- encoding: utf-8 -*-
import os
import sys
from typing import List
from collections import defaultdict


#Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
#You may assume that the intervals were initially sorted according to their start times.

#Example 1:
#Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
#Output: [[1,5],[6,9]]


#Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
#Output: [[1,2],[3,10],[12,16]]
#Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

def insert(intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
# def insert(intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
    result = []
    start = newInterval[0]
    end = newInterval[1]

    left = [i for i in intervals if start > i[1]]
    right = [i for i in intervals if end < i[0]]

    if len(letf) + len(right) != len(intervals):
        start = min(start, intervals[len(left)][0])
        end = max(end , intervals[~len(right)][1])

    if left:
        result.extend(left)
    result.append([start,end])
    if right:
        result.extend(right)
    return result

    
    



if '__main__' == __name__:

    nums = [[1, 3],[6, 9]]
    newInterval = [2,5]

    nums = [[1,2],[3,5],[6,7],[8,10],[12,16]]
    newInterval = [4,8]
    result = insert(nums, newInterval)
    print(result)
    


