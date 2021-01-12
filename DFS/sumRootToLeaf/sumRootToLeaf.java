import java.util.*;

public class sumRootToLeaf {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }
    /**
      Given a binary tree containing digits from 0-9 only, 
      each root-to-leaf path could represent a number.
      An example is the root-to-leaf path 1->2->3 which represents the number 123.
      Find the total sum of all root-to-leaf numbers.
      Note: A leaf is a node with no children.
      
      Example:
      Input: [1,2,3]
          1
         / \
        2   3
      Output: 25
      Explanation:
      The root-to-leaf path 1->2 represents the number 12.
      The root-to-leaf path 1->3 represents the number 13.
      Therefore, sum = 12 + 13 = 25.
    */

    public int sumNumbers(TreeNode root) {

        int result = 0;
        List<Integer> solution = new ArrayList<>();
        dfs (root, 0, solution);
        
        for (Integer x : solution) {
            result += x;
        }
        return result;
    }

    private void dfs(TreeNode root, int path, List<Integer> solution) {

        if (root == null)
            return;

        path = 10 * path + root.val; 
        if (root.left == null && root.right == null) {
            solution.add(path);
            return;
        } 

        if (root.left != null)
            dfs(root.left, path, solution);
        if (root.right != null)
            dfs(root.right, path, solution);

    }

    public static void main(String[] args) {
        
    }

}
