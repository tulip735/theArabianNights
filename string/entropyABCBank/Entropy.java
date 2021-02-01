import java.util.*;



public class Entropy {

    public static double entropy(String s) {

        double res = 0.0;
        HashMap<Character,Integer> m = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (m.containsKey(c)) {
                m.put(c, m.get(c) + 1);
            } else {
                m.put(c, 1);
            }
        }

        for (Character c : m.keySet()) {
            double p = (double) m.get(c) / s.length();
            res += p * (Math.log(p) / Math.log(2));
        }
        return -res;
    }



    public static void main(String[] args) {

        double res = entropy("AABB");
        System.out.println(res);
        
    }
}
