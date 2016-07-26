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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            List<Integer> retList = new LinkedList<Integer>();
            return retList;
        }
        
        List<Integer> leftList = postorderTraversal(root.left);
        List<Integer> rightList = postorderTraversal(root.right);
        
        List<Integer> combinedList = new LinkedList<Integer>();
        combinedList.addAll(leftList);
        combinedList.addAll(rightList);
        combinedList.add(root.val);
        
        return combinedList;
    }
}