o/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Decision {
public:
    int toTake;
    int orNotToTake;
    Decision() {
        toTake = 0;
        orNotToTake = 0;
    }
};

class Solution {
public:
    int rob(TreeNode* root) {
        if(root == NULL) {
            return 0;
        }
        Decision* decision = makeDecision(root);
        return max(decision->toTake,decision->orNotToTake);
    }
private:
    Decision* makeDecision(TreeNode* root){
        if(root == NULL){
            Decision* decision = new Decision();
            return decision;
        }
 
        Decision* result = new Decision();
        Decision* left = makeDecision(root->left);
        Decision* right = makeDecision(root->right);
  
        result->toTake = root->val + left->orNotToTake + right->orNotToTake;
        result->orNotToTake = max(left->toTake, left->orNotToTake) + max(right->toTake, right->orNotToTake);
 
        return result;
    }
};
