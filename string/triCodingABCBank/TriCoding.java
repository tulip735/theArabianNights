import java.util.*;


public class TriCoding {

    /**
     火星使用三进制表示数据，他们的数字符号：@、$、& 这三个符号分别表示 0、1、2 。
     现在输入一个十进制数，请把它用火星的三进制数表示出来。
     示例：
     输入：123
     输出："$$$&@"
    */

    public static String triCoding(int num) {
        if (num == 0)
            return "@";

        boolean sign = false;
        if (num < 0) {
            sign = true;
            num = -num;
        }

        String mod = "@$&";
        String res = "";
        while (num > 0) {
            res += mod.charAt(num % 3);
            num = num / 3;
        }
        if (sign)
            res = res + "-";
        StringBuilder out = new StringBuilder(res);
        return out.reverse().toString();
       
    }


    public static void main(String[] args) {

        int x = 123;
        String y = triCoding(x);
        System.out.println(y);
    }
}
