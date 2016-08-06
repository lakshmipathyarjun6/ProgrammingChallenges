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
    int countNodes(TreeNode* root) {
        if(root == NULL) {
            return 0;
        }
        
        int left = getLeftHeight(root)+1;    
        int right = getRightHeight(root)+1;
 
        if(left == right) {
            return (2 << (left-1))-1;
        }
        else {
            return countNodes(root->left) + countNodes(root->right) + 1;
        }
    }
private:
    int getLeftHeight(TreeNode* n) {
        if(n == NULL) { 
            return 0;
        }
        int height=0;
        while(n->left != NULL) {
            height++;
            n = n->left;
        }
        return height;
    }
    int getRightHeight(TreeNode* n) {
        if(n == NULL) { 
            return 0;
        }
        int height=0;
        while(n->right != NULL) {
            height++;
            n = n->right;
        }
        return height;
    }
};

