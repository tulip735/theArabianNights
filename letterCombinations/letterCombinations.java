



import java.util.*;


public class letterCombinations {



    /**
       Given a string containing digits from 2-9 inclusive,
       return all possible letter combinations that the number could represent.
    */

    private static final String[] keyboard  = new String[] {"", "","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 

    public static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if(digits.isEmpty())
            return result;

        dfs(digits,0,"",result);
        return result;

    }

    private static void dfs(String digits,int cur, String path, List<String> result) {

        if(cur == digits.length()){
            result.add(path);
            return;
        }
        final String letter = keyboard[digits.charAt(cur) - '0'];

        for (char c : letter.toCharArray()) {
            dfs(digits, cur + 1, path + c, result);
        }

    }


    public static void main(String[] args) {

        String digits = "23";
        List<String> result = letterCombinations(digits);
        for(String c : result) {
            System.out.println(c);
        }

    }
}









