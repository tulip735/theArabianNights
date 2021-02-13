package tree.flattenBinaryTreeToLinkedList;

import java.util.*;
import tree.buildTree.*;

public class FlattenTree {


    /**
    Given the root of a binary tree, flatten the tree into a "linked list":
    The "linked list" should use the same TreeNode class where the right child 
    pointer points to the next node in the list and the left child pointer is always null.
    The "linked list" should be in the same order as a pre-order traversal 
    of the binary tree.
    */

    // attach original right as the right child of the rigthmost node of left subtree,
    // set original left as new right child.
    // repeat with next right child.

    public static void flatten(TreeNode root) {

        TreeNode now = root;
        while (now != null) {
            TreeNode l = now.left;
            TreeNode r = now.right;

            if (l != null) {
                TreeNode tmp = l;
                // find the rightmost node of left subtree
                while (tmp.right != null)
                    tmp = tmp.right;
                
                // attach original right as the right child of
                // the rigthmost node of left subtree,
                tmp.right = r;

                // set original left as new right child.
                now.right = l;
                now.left = null;
                
            }
            // repeat the next node
            now = now.right;
        }
        
    }



    public static void flattenRecursive(TreeNode root) {
        if (root == null)
            return;

        flattenRecursive(root.left);
        flattenRecursive(root.right);

        if (root.left == null)
            return;

        // 三方合并，将左子树形成的链表插入到root 和root.right之间
        TreeNode p = root.left;
        // 找到左子树最右一个节点
        while (p.right != null)
            p = p.right;
        p.right = root.right;
        root.right = root.left;
        root.left = null;
    }

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,5,3,4,-1,6};
        TreeNode root = TreeNode.buildTree(nums);
        // flatten(root);
        flattenRecursive(root);
        TreeNode.printTree(root);
        while(root != null) {
            System.out.printf("%d\t", root.val);
            root = root.right;
        }
        System.out.println();
        
    }
}
