package tree.buildTree;
import java.util.*;



public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode (int x) {val = x;}

    public static TreeNode buildTree(int[] nums) {

        return buildHelper(nums, 0);
    }

    public static TreeNode buildHelper(int[] nums, int index) {
        TreeNode root = null;
        if (index < nums.length) {
            if (nums[index] == -1) {
                return root;
            } else {
                root = new TreeNode(nums[index]);
                root.left = buildHelper(nums, 2 * index + 1);
                root.right = buildHelper(nums, 2 * index + 2);
            }
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
    }





}
