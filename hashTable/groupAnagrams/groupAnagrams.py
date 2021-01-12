#! -*- encoding: utf-8 -*-
import os
import sys
from typing import List
from collections import defaultdict
#    Given an array of strings, group anagrams together.
#    Example:
#    Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
#    Output:
#    [
#      ["ate","eat","tea"],
#      ["nat","tan"],
#      ["bat"]
#    ]
def groupAnagrams(strs:List[str]) -> List[List[str]]:
    result = []
    m = defaultdict(list)

    for s in strs:
        m[tuple(sorted(s))].append(s)

    return list(m.values())
        



if '__main__' == __name__ :
    strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
    res = groupAnagrams(strs)
    print(res)
    print("ok")
