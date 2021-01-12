#include <iostream>
#include <vector>
#include <stack>

//#include "BinarySearchTree.h"


using namespace std;

/**
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
Example 1:
Input: root = [3,1,4,null,2], k = 1
        3
       / \
      1   4
    /  \
   0    2
Output: 1
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode (int x) : val(x) , left(NULL), right(NULL) {}
};


int kthSmallest(TreeNode *root, int k) {

    if (root == NULL)
        return -1;
    //利用中序遍历的思想
    stack<TreeNode *> s;
    while (!s.empty() || root != nullptr) {
        while (root) {
            s.push(root);
            root = root->left;
        }
        root = s.top();
        s.pop();
        if (--k ==0)
            return root->val;
        root = root->right;
        
    }
    return -1;
}


int main() {

    return 0;
}
