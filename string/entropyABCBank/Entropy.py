#! -*- encoding: utf-8 -*-
import os
import sys
import math

from collections import defaultdict






def entropy(s : str) -> float:
    res = 0.0
    d = defaultdict(int)
    for c in s:
        d[c] += 1
    for c in d.keys():
        p = (float) (d[c]) / len(s)
        res += p * math.log(p, 2)
    return -round(res,2)




if __name__ == '__main__':


    res = entropy("AABBc")
    print(res)



