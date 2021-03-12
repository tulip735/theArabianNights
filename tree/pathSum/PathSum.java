package tree.pathSum;

import java.util.*;
import tree.buildTree.*;

public class PathSum {

    /**
      Given the root of a binary tree and an integer targetSum, 
      return all root-to-leaf paths where each path's sum equals targetSum.
      Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
      Output: [[5,4,11,2],[5,8,4,5]]
    */

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> path = new LinkedList<>();

        pathSumHelper(root, targetSum, path, result);

        return result;
        
    }

    public static void pathSumHelper(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> result) {
        if (root == null)
            return;

        path.add(root.val);
        if (root.left == null && root.right == null) {
            // System.out.println(path);
            if (root.val == targetSum) {
                System.out.println(path);
                // path.add(root.val);
                // result.add(path);
                result.add(new LinkedList<>(path));
            }
        }

        pathSumHelper(root.left, targetSum - root.val, path, result);
        pathSumHelper(root.right, targetSum - root.val, path, result);
        
        path.remove(path.size() - 1);
        
    }



    public static void main(String[] args) {

        int[] nums = new int[] {5,4,8,11,-1,13,4,7,2,-1,-1,-1,-1,5,1};

        TreeNode root = TreeNode.buildTree(nums);
        // TreeNode.printTree(root);
        List<List<Integer>> res = pathSum(root, 22);
        System.out.println(res);
        
    }


    
}
