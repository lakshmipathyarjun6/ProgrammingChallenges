/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
#include <cmath>
using namespace std; 
 
class Solution {
public:
    bool isBalanced(TreeNode* root) {
        if(checkHeight(root) == -1) {
            return false;
        }
        return true;
    }
private:
    int checkHeight(TreeNode* root) {
        if(root == NULL) {
            return 0;
        }
        
        int leftHeight = checkHeight(root->left);
        if(leftHeight == -1) {
            return -1;
        }
        
        int rightHeight = checkHeight(root->right);
        if(rightHeight == -1) {
            return -1;
        }
        
        int heightDiff = leftHeight - rightHeight;
        if(abs(heightDiff) > 1) {
            return -1;
        }
        else {
            return max(leftHeight,rightHeight) + 1;
        }
    }
};

