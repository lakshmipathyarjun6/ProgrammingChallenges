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
    public List<List<Integer>> findPaths(TreeNode root, List<Integer> currentList, int amountLeft) {
        
        currentList.add(root.val);
        
        if(root.left == null && root.right == null) {
            List<List<Integer>> retList = new ArrayList<List<Integer>>();
            if(amountLeft-root.val == 0) {
                retList.add(currentList);
            }
            return retList;
        }
    
        List<List<Integer>> rightList = null;
        List<List<Integer>> leftList = null;
        
        if(root.right != null) {
            rightList = findPaths(root.right,new ArrayList<Integer>(currentList),amountLeft-root.val);
        }
        if(root.left != null) {
            leftList = findPaths(root.left,new ArrayList<Integer>(currentList),amountLeft-root.val);
        }
        
        List<List<Integer>> finalList = null;
        
        if(leftList != null && rightList != null) {
            leftList.addAll(rightList);
            finalList = leftList;
        }
        else if(leftList != null) {
            finalList = leftList;
        }
        else {
            finalList = rightList;
        }
           
        return finalList;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) {
            List<List<Integer>> retList = new ArrayList<List<Integer>>();
            return retList;
        }
        
        return findPaths(root, new ArrayList<Integer>(), sum);
        
    }
}
