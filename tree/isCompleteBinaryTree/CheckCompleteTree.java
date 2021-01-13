import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}



public class CheckCompleteTree {

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


    

    

    /**
     Given the root of a binary tree, determine if it is a complete binary tree.
     In a complete binary tree, every level, except possibly the last, 
     is completely filled, and all nodes in the last level are as far left as possible. 
     It can have between 1 and 2^h nodes inclusive at the last level h.

     Input: root = [1,2,3,4,5,null,7]
     Output: false
     Explanation: The node with value 7 isn't as far left as possible.
    */

    public static boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while (q.peek() != null) {
            TreeNode tmp = q.poll();
            q.offer(tmp.left);
            q.offer(tmp.right);
        }

        while (!q.isEmpty() && q.peek() == null) {
            q.poll();
        }
        return q.isEmpty();
        
    } 





    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3,4,5,-1,7};

        TreeNode root = buildTree(nums);
        printTree(root);
        boolean res = isCompleteTree(root);
        if (res) {
            System.out.println("ok");
        } else {
            System.out.println("no");
        }

        
    }
}
