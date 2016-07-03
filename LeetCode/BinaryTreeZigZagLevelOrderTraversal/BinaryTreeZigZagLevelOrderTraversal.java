/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        
        if(root == null) {
            return results;
        }
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(root);
        
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        Stack<TreeNode> cur = s1;
        
        List<Integer> result = new ArrayList<Integer>();
        
        while (!s1.empty() || !s2.empty()) {
            if (cur == s1) {
                TreeNode tmp = s1.peek();
                s1.pop();
                result.add(tmp.val);
                if (tmp.left != null)
                    s2.push(tmp.left);
                if (tmp.right != null)
                    s2.push(tmp.right);
                if (s1.empty()) {
                    results.add(result);
                    result = new ArrayList<Integer>();
                    cur = s2;
                }
                
            }
            else {
                TreeNode tmp = s2.peek();
                s2.pop();
                result.add(tmp.val);
                if (tmp.right != null)
                    s1.push(tmp.right);
                if (tmp.left != null)
                    s1.push(tmp.left);
                if (s2.empty()) {
                    results.add(result);
                    result = new ArrayList<Integer>();
                    cur = s1;
                }
            }
        }
        
        return results;
    }
}