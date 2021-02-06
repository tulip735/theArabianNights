package tree.binaryTreeLevelOrderTraversal;

import java.util.*;
import tree.buildTree.*;



public class BinaryTreeLevelOrderTraversal {

    /**
     Given a binary tree, return the level order traversal of its nodes' values. 
     (ie, from left to right, level by level).
     
     For example:
     Given binary tree [3,9,20,null,null,15,7],
         3
        / \
       9  20
         /  \
        15   7
     return its level order traversal as:
     [
       [3],
       [9,20],
       [15,7]
     ]
    */

    public static List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> cur = new LinkedList<>();
        Deque<TreeNode> next = new LinkedList<>();
        if (root == null) {
            return result;
        } else {
            cur.offer(root);
            
        }

        while (!cur.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            while (!cur.isEmpty()) {
                TreeNode tmp = cur.poll();
                level.add(tmp.val);
                if (tmp.left != null)
                    next.offer(tmp.left);
                if (tmp.right != null)
                    next.offer(tmp.right);
                
            }
            result.add(level);
            cur = next;
            next = new LinkedList<>();
            
        }

        return result;
        
    }



    public static void main(String[] args) {


        int[] nums = new int[] {3,9,20,-1,-1,15,7};
        TreeNode root = TreeNode.buildTree(nums);
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
        
    }
}
