/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
 #include <limits>
 
 using namespace std;
 
class Solution {
public:
    int maxPathSum(TreeNode* root) {
        int max = numeric_limits<int>::min();
        calculateSum(root,max);
        return max;
    }
    
    int calculateSum(TreeNode* root, int& maxVal) {
        if (root == NULL) {
            return 0;
        }
 
        int left = calculateSum(root->left, maxVal);
        int right = calculateSum(root->right, maxVal);
 
        int current = max(root->val, max(root->val + left, root->val + right));
        maxVal = max(maxVal, max(current, left + right + root->val));
 
        return current;
    }
};
