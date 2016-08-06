/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class BSTIterator {
public:
    BSTIterator(TreeNode* root) {
        TreeNode* current = root;
        
        while(current != NULL) {
            st.push(current);
            current = current->left;
        }
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !st.empty();
    }

    /** @return the next smallest number */
    int next() {
        TreeNode* next = st.top();
        st.pop();
        if(next->right != NULL) {
            st.push(next->right);
            
            TreeNode* lc = next->right->left;
            while(lc != NULL) {
                st.push(lc);
                lc = lc->left;
            }
        }
        
        return next->val;
    }
private:
    stack<TreeNode*> st;
};

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = BSTIterator(root);
 * while (i.hasNext()) cout << i.next();
 */
