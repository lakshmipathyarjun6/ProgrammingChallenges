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
    int kthSmallest(TreeNode* root, int k) {
        // Count to iterate over elements till we
        // get the kth smallest number
        int count = 0;
        
        int ksmall = INT_MIN; // store the Kth smallest
        TreeNode* curr = root; // to store the current node
        
        while (curr != NULL) {
            if (curr->left == NULL) {
                count++;
                
                if (count==k) {
                    ksmall = curr->val;
                }
                
                curr = curr->right;
            }
            
            else {
                TreeNode* pre = curr->left;
                while (pre->right != NULL && pre->right != curr)
                pre = pre->right;
                
                // building links
                if (pre->right==NULL) {
                    //link made to Inorder Successor
                    pre->right = curr;
                    curr = curr->left;
                }
                
                else {
                    pre->right = NULL;
                    
                    count++;
                    
                    if (count==k) {
                        ksmall = curr->val;
                    }
                    
                    curr = curr->right;
                }
            }
        }
        return ksmall; //return the found value
    }
};