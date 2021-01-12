


import java.util.*;


public class lengthOfLongestSubstring {

    /**
     Given a string, find the length of the longest substring without repeating characters.
     Example 1:
     Input: "abcabcbb"
     Output: 3 
     Explanation: The answer is "abc", with the length of 3. 

     Input: "pwwkew"
     Output: 3
     Explanation: The answer is "wke", with the length of 3. 
     Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
    */
    public static int lengthOfLongestSubstring (String s) {
        int n = s.length();
        if (n == 0)
            return 0;
        int result = 0;
        int[] index = new int[128];
        Arrays.fill(index,-1);

        for (int i = 0, j = 0; j < n; j++) {
            //System.out.println(i);
            if (index[s.charAt(j)] > -1) {
                //System.out.println(index[s.charAt(j)]);
                // 如果当前字符出现在集合中，则更新left pointer,选择当前i和当前字符在集合
                //中的index较大的，因为[i,j)始终为没有重复元素的集合，i可能因为其他字符移动了
                i = Math.max(index[s.charAt(j)] + 1, i);
                //i = index[s.charAt(j)] + 1;
            }
            index[s.charAt(j)] = j;
            result = Math.max(result,j - i + 1);
            
        }
        return result;
    }

    public static void main(String[] args) {

        String s = "acbdca";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);
        
    }
}


