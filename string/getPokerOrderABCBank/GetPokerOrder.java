import java.util.*;
public class GetPokerOrder {


    /**
     一副扑克牌中的牌面分为 5 种花色：大小鬼、黑桃、红桃、梅花、方块，分别用 k、s、h、p、q 表示这五种花色，同时牌面采用 1~13 之间的数字表示同一花色中的大小（小鬼-1，大鬼-2）。
    某扑克牌游戏中，一个玩家拿到了 12 张扑克牌，请按照如下规则对该玩家的牌进行排序，返回排序结果。
     
     首先按照大小鬼、、黑桃、红桃、梅花、方块进行花色排序；
     然后再对同一花色中的扑克牌按照数字从小到大排序。

     示例：
     输入：["s1", "s3", "s9", "s4", "h1", "p3", "p2", "q5", "q4", "q9", "k2", "k1"]
     输出：["k1", "k2", "s1", "s3", "s4", "s9", "h1", "p2", "p3", "q4", "q5", "q9"]

    */

    public static ArrayList<String> getPokerOrder(String[] cards) {

        ArrayList<String> res = new ArrayList<>();
        String keys = "kshpq";
        LinkedHashMap<Character,ArrayList<String>> m = new LinkedHashMap<>();
        for (String s : cards) {
            if (m.containsKey(s.charAt(0))) {
                m.get(s.charAt(0)).add(s);
            } else {
                m.put(s.charAt(0), new ArrayList<String>());
                m.get(s.charAt(0)).add(s);
            }
        }

        for (int i = 0; i < keys.length(); i++) {
            Collections.sort(m.get(keys.charAt(i)));
            for (String s : m.get(keys.charAt(i))) {
                res.add(s);
            }

        }
        return res;
    }


    public static void main(String[] args) {


        String[] cards = new String[] {"s1", "s3", "s9", "s4", "h1", "p3", "p2", "q5", "q4", "q9", "k2", "k1"};
        ArrayList<String> res = getPokerOrder(cards);
        for (String str : res) {
            System.out.println(str);
        }
        
    }
}
