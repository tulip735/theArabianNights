import java.util.*;

public class GroupAnagrams {
    /**
      Given an array of strings, group anagrams together.
      Example:
      Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
      Output:
      [
        ["ate","eat","tea"],
        ["nat","tan"],
        ["bat"]
      ]
    */
    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0)
            return new ArrayList<>();

        Map<String, List<String>> m = new HashMap<>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            String keyStr = String.valueOf(tmp);
            if (!m.containsKey(keyStr))
                m.put(keyStr, new ArrayList<>());
            m.get(keyStr).add(str);
        }

        return new ArrayList<>(m.values());
        
    }

    public static void main(String[] args) {

        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = groupAnagrams(strs);
        // System.out.println(res.toString());
        
    }
}
