package tree.isValidBinarySearchTree;
import java.util.*;
import tree.buildTree.*;

public class ValidBST {

    /**
      Given the root of a binary tree, determine if it is a valid binary search tree (BST).
      A valid BST is defined as follows:
      The left subtree of a node contains only nodes with keys less than the node's key.
      The right subtree of a node contains only nodes with keys greater than the node's key.
      Both the left and right subtrees must also be binary search trees.
    */
    public static boolean isValidBST(TreeNode root) {

        return isValidHelper(root, null, null);
        
    }

    public static boolean isValidHelper(TreeNode root, Integer l, Integer r) {

        if (root == null)
            return true;
        if (l != null && root.val < l)
            return false;
        if (r != null && root.val > r)

        return (isValidHelper(root.left, l, root.val ) && isValidHelper(root.right, root.val, r));
        
    }


    // inorder iterative
    public static boolean isValidBSTInorderIter(TreeNode root) {


        
    }



    public static void main(String[] args) {

        // int[] nums = new int[]{2, 1, 3};
        int[] nums = new int[] {5, 1, 4, -1, -1, 3, 6};
        // 静态方法可以直接调用 buildTree和printTree
        TreeNode root = TreeNode.buildTree(nums);
        TreeNode.printTree(root);
        if (isValidBST(root))
            System.out.println("ok");

        
    }
}
