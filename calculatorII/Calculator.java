import java.util.*;

class Calculator {

    /*
     Implement a basic calculator to evaluate a simple expression string.
     The expression string contains only non-negative integers, +, -, *, / operators and empty spaces. 
     The integer division should truncate toward zero.
     
     Example 1:
     Input: "3+2*2 + 5" "32-45"
     Output: 7
    */
    public static int calculate(String s) {

        int n = s.length();
        if (n == 0)
            return 0;
        int res = 0;
        int pre = 0, cur = 0;
        char sign = '+';
        // 35+2*2+3
        //while(i < s.length()) {
        for (int i = 0; i < s.length(); i++) {

            if (i < n && (s.charAt(i) - '0') >= 0 && (s.charAt(i) - '0') <= 9) {
                cur = 10 * cur + (s.charAt(i) - '0');
            } 

           
            if ( (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' ) || i == s.length() - 1) {
                if (sign == '+') {
                    res += pre;
                    pre = cur;
                } else if (sign == '-') {
                    res += pre;
                    pre = -cur;
                } else if (sign == '*') {

                    pre = pre * cur;

                } else if (sign == '/') {

                    pre = pre / cur;
                }

                sign = s.charAt(i);
                cur = 0; // 每次重置cur
            }
        }
        res += pre;
        return res;
    }


    public static void main(String[] args) {

        String s = "-1 0 + 2 * 2 *     3 ";
        int n = calculate(s);
        System.out.println(n);
        
    }
}

