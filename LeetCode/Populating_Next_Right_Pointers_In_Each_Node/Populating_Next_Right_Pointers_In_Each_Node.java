/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private List<List<TreeLinkNode>> createLevelList(TreeLinkNode root) {
        List<List<TreeLinkNode>> result = new ArrayList<List<TreeLinkNode>>();
        List<TreeLinkNode> current = new LinkedList<TreeLinkNode>();
        
        if(root != null) {
            current.add(root);
        }
        
        while(current.size() > 0) {
            result.add(current);
            List<TreeLinkNode> parents = current;
            current = new LinkedList<TreeLinkNode>();
            
            for(TreeLinkNode parent : parents) {
                if(parent.left != null) {
                    current.add(parent.left);
                }
                if(parent.right != null) {
                    current.add(parent.right);
                }
            }
        }
        
        return result;
    }
    
    public void connect(TreeLinkNode root) {
        List<List<TreeLinkNode>> sortedList = createLevelList(root);
        
        for(List<TreeLinkNode> levelList : sortedList) {
            for(int i = 0; i < levelList.size(); i++) {
                levelList.get(i).next = (i+1 >= levelList.size()) ? null : levelList.get(i+1);
            }
        }
    }
}