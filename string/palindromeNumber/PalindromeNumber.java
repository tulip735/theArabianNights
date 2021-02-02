import java.util.*;



public class PalindromeNumber {


    /**
      Given an integer x, return true if x is palindrome integer.
      An integer is a palindrome when it reads the same backward as forward. 
      For example, 121 is palindrome while 123 is not.
    */


    public static boolean isPalindrome(int num) {

        if (num < 0 || (num % 10 == 0 && num != 0)) {
            return false;
        }

        int tmp = 0;
        while (tmp < num) {
            tmp = 10 * tmp + num % 10;
            num /= 10;
        }
        if (tmp == num || (tmp / 10) == num)
            return true;
        
        return false;
    }



    public static void main(String[] args) {

        if (isPalindrome(1)) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        } 
    }
}
