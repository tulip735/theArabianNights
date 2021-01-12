
import java.util.*;
public class restoreIpAddresses {
    /**
      Given a string containing only digits, 
      restore it by returning all possible valid IP address combinations.
      Example:
      Input: "25525511135"
      Output: ["255.255.11.135", "255.255.111.35"]
    */
    public static List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(s, path, result, 0);
        return result;

    }


    private static void dfs(String s, List<String> path, List<String> result, int pos) {

        //System.out.println("ok");
        if (path.size() > 4)
            return;
        if (path.size() == 4 && pos == s.length()) {
            result.add(String.join(".",path));
            return;
        }

        // 剪枝
        if (s.length() - pos > (4 - path.size()) * 3)
            return;
        if (s.length() - pos < 4 - path.size())
            return;

        for (int i = 1; i < 4; i++) {
            if (pos + i > s.length())
                break;
            String tmp = s.substring(pos, pos + i);
            System.out.println(tmp);

            // 剪枝 0开始，和大于255
            if (tmp.startsWith("0") && tmp.length() > 1)
                break;
            if ( i ==3 && Integer.parseInt(tmp) > 255)
                break;

            path.add(tmp);
            dfs(s, path, result, pos + i);
            path.remove(path.size() - 1);
        }
        
    }


    public static void main(String[] args) {

        int x = '5' - '0';
        String s = "25525511135";
        List<String> result = restoreIpAddresses(s);
        System.out.println(result.size());
        for (String c : result) {
            System.out.println(c);
        }


    }
}






















