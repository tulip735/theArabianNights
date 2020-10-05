#! -*- encoding: utf-8 -*-
import os
import sys
import math
# Implement a basic calculator to evaluate a simple expression string.
# 
# The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
# The integer division should truncate toward zero.
# 
# Example 1:
# 
# Input: "3+2*2"
# Output: 7
def calculate(s: str) -> int:

    n = len(s)
    if n == 0:
        return 0
    pre, cur, res, sign = 0, 0, 0, '+'

    "3 + 2 * 2"
    for i in range(n):
        c = s[i]
        if c.isdigit():
            cur = 10 * cur + int(c)
        if (not c.isdigit() and c != ' ' ) or i == n - 1:
            if sign == '+':
                res += pre
                pre = cur
            if sign == '-':
                res += pre
                pre = -cur
            if sign == '*':
                pre = pre * cur
            if sign == '/':
                
                pre = math.trunc(pre / cur)
                #-3/2 = -1.5 python3
                #-3/2 = -2 python2

            sign = c
            cur = 0
    res += pre
    return res

if __name__ == '__main__':

    s = "14 - 3/2"
    res = calculate(s)
    print(res)
    






