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
    public TreeNode createTree(int [] nums, int left, int right) {
        if(left > right) {
            return null;
        }
        
        int mid = (left + right)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = createTree(nums, left, mid-1);
        root.right = createTree(nums, mid+1, right);
        
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) {
            return null;
        }
        
        return createTree(nums,0,nums.length-1);
    }
}
