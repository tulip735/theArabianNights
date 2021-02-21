import java.util.*;


public class PopulatingNextRrightPointers {



    /**
      You are given a perfect binary tree where all leaves are on the same level, 
      and every parent has two children. The binary tree has the following definition:
      
      struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
      }
      Populate each next pointer to point to its next right node. 
      If there is no next right node, the next pointer should be set to NULL.
      Initially, all next pointers are set to NULL.
      
            1                  1 -> null
      
         2     3           2 ->   3 -> null
      
      4    5  6   7     4 ->  5 -> 6  -> 7 -> null

    */

    public Node connect(Node root) {

        // 层序遍历迭代法
        Node pre = root;
        while (pre != null) {
            Node cur = pre;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            pre = pre.left;
        }

        return root;
        
    }


    public void connectDFS(Node root) {
        if(root == null)
            return;
        
        if(root.left != null) {
            root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        }
    
        connectDFS(root.left);
        connectDFS(root.right);
    }


    public static void main(String[] args) {

        
    }
}
