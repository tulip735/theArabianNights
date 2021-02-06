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



    public static List<List<Integer>> levelOrderOneQueue(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) {
            return result;
        } else {
            q.offer(root);
        }
        
        while (!q.isEmpty()) {
            List<Integer> sub = new ArrayList<>();
            int subLen = q.size();
            for (int i = 0; i < subLen; i++) {
                if (q.peek().left != null)
                    q.offer(q.peek().left);
                if (q.peek().right != null)
                    q.offer(q.peek().right);

                sub.add(q.poll().val);
            }
            
            result.add(sub);
        }
        return result;
    }

    public static void main(String[] args) {


        int[] nums = new int[] {3,9,20,-1,-1,15,7};
        TreeNode root = TreeNode.buildTree(nums);
        // List<List<Integer>> result = levelOrder(root);
        List<List<Integer>> result = levelOrderOneQueue(root);
        System.out.println(result);
        
    }
}
