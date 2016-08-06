/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int sumNumbers(TreeNode* root) {
        return sumNumbersHelper(root, 0);
    }
private:
    int sumNumbersHelper(TreeNode* root, int prevVal) {
        if(root == NULL) {
            return 0;
        }   
        else if(root->left == NULL && root->right == NULL) { // leaf node
            return root->val + prevVal;
        }
        else {
            int computedVal = 10*(prevVal + root->val);
            return sumNumbersHelper(root->left,computedVal) + sumNumbersHelper(root->right,computedVal);
        }
    }
};
    
