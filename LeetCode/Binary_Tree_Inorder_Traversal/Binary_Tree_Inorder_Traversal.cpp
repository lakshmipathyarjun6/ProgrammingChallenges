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

    void inorderTraversalHelper(TreeNode* root, vector<int>& st) {
        if(!root) {
            return;
        }
        else {
            inorderTraversalHelper(root->left, st);
            st.push_back(root->val);
            inorderTraversalHelper(root->right, st);
        }
    }

    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ordered;
        inorderTraversalHelper(root, ordered);
        return ordered;
    }
};
