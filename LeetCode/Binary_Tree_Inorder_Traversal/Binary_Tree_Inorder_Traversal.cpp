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
    
    void inorderTraversalHelper(TreeNode* root, queue<int>& st) {
        if(!root) {
            return;
        }
        
        else {
            inorderTraversalHelper(root->left, st);
            st.push(root->val);
            inorderTraversalHelper(root->right, st);
        }
        
    }
    
    vector<int> inorderTraversal(TreeNode* root) {
        
        queue<int> traversal;
        inorderTraversalHelper(root, traversal);
        
        vector<int> ordered;
        
        while(!traversal.empty()) {
            ordered.push_back(traversal.front());
            traversal.pop();
        }
        
        return ordered;
    }
};