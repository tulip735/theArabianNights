import java.util.*;

public class kthSmallest {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
    }

    /**
      Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
      Note:
      You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
    */

    int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> s = new Stack<>();
        while (!s.empty() || root != null) {
            while (root != null) {
                s.add(root);
                root = root.left;
            }

            root = s.pop();
            if (--k == 0)
                return root.val;
            root = root.right;
        }
        return -1;
    }



    public static void main(String[] args) {
        
    }
    
}
