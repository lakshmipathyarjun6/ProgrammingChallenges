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
    private void createLinkedLists(TreeNode root, List<List<Integer>> lists, int level) {
        if(root == null) {
            return;
        }
        
        List<Integer> list = null;
        if(lists.size() == level) {
            list = new LinkedList<Integer>();
            lists.add(list);
        }
        else {
            list = lists.get(level);
        }
        list.add(root.val);
        
        createLinkedLists(root.left,lists,level+1);
        createLinkedLists(root.right,lists,level+1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        createLinkedLists(root,lists,0);
        return lists;
    }
}