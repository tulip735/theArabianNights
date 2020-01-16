# -*- coding:utf-8 -*-


def lengthOfLongestSubstring(s: str) -> int:
    n = len(s)
    if n == 0:
        return 0
    i,result,index = 0,0,{}

    for j in range(n):
        if s[j] in index:
            i = max(i,index[s[j]] + 1)
        
        result = max(result, j - i + 1)
        index[s[j]] = j
    return result
    


if __name__ == "__main__":
    s = "abbbbba"
    result = lengthOfLongestSubstring(s)
    print(result)
