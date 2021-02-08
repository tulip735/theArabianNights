package tree.balancedTree;

import java.util.*;
import tree.buildTree.*;



public class BalancedTree {


    /**
       Given a binary tree, determine if it is height-balanced.
       For this problem, a height-balanced binary tree is defined as:
       a binary tree in which the left and right subtrees of every node 
       differ in height by no more than 1.
       
       Input: root = [1,2,2,3,3,null,null,4,4]
       Output: false
       Input: root = []
       Output: true
    */
    

    public static boolean isBalanced(TreeNode root) {

        return dfsHeight(root) != -1;
    }
       // The second method is based on DFS.
       // Instead of calling depth() explicitly for each child node,
       // we return the height of the current node in DFS recursion.
       // When the sub tree of the current node (inclusive) is balanced,
       // the function dfsHeight() returns a non-negative value as the height.
       // Otherwise -1 is returned.
       // According to the leftHeight and rightHeight of the two children,
       // the parent node could check if the sub tree is balanced, and decides its return value.
    public static int dfsHeight(TreeNode root) {
        if (root == null)
            return 0;
        int l = dfsHeight(root.left);
        if (l < 0)
            return -1;
        int r = dfsHeight(root.right);
        if (r < 0)
            return -1;

        if (l - r > 1 || l -r < -1)
            return -1;

        return Math.max(l, r) + 1;
    }



    // 自顶向下方法
    // For the current node root, calling depth() for its left and right children
    // actually has to access all of its children, thus the complexity is O(N).
    // We do this for each node in the tree, so the overall complexity of isBalanced will be O(N^2).
    // This is a top down approach.
    public static boolean isBalancedTopDown(TreeNode root) {

        if (root == null)
            return true;

        int l = depth(root.left);
        int r = depth(root.right);
        if (Math.abs(l - r) > 1)
            return false;

        return isBalancedTopDown(root.left) && isBalancedTopDown(root.right);
        
    }

    public static int depth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
        
    }


    public static void main(String[] args) {

        int[] nums = new int[] {1,2,2,3,3,-1,-1,4,4};
        TreeNode root = TreeNode.buildTree(nums);
        // if (isBalanced(root))
        if (isBalancedTopDown(root))
            System.out.println("ok");
        
    }


}





