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
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        else if(root.left == null || root.right == null) {
            return false;
        }

        LinkedList<Pair> q1 = new LinkedList<Pair>();
        LinkedList<Pair> q2 = new LinkedList<Pair>();
        Pair q1p = new Pair();
        q1p.node = root.left;
        q1p.dir = 'L';
        q1p.parent = null;
        Pair q2p = new Pair();
        q2p.node = root.right;
        q2p.dir = 'R';
        q2p.parent = null;
        
        q1.add(q1p);
        q2.add(q2p);
        
        while(q1.size() != 0 && q2.size() != 0) {
            Pair q1Front = q1.pop();
            Pair q2Front = q2.pop();
            if(q1Front.node.val != q2Front.node.val || q1Front.dir == q2Front.dir) {
                return false;
            }
            else if(q1Front.parent != q2Front.parent) {
                return false;
            }
            
            if(q1Front.node.right != null) {
                Pair p = new Pair();
                p.node = q1Front.node.right;
                p.dir = 'R';
                p.parent = q1Front.node.val;
                q1.add(p);
            }
            if(q1Front.node.left != null) {
                Pair p = new Pair();
                p.node = q1Front.node.left;
                p.dir = 'L';
                p.parent = q1Front.node.val;
                q1.add(p);
            }
            if(q2Front.node.left != null) {
                Pair p = new Pair();
                p.node = q2Front.node.left;
                p.dir = 'L';
                p.parent = q2Front.node.val;
                q2.add(p);
            }
            if(q2Front.node.right != null) {
                Pair p = new Pair();
                p.node = q2Front.node.right;
                p.dir = 'R';
                p.parent = q2Front.node.val;
                q2.add(p);
            }
        }
        if(q1.size() != 0 || q2.size() != 0) {
            return false;
        }
        
        return true;
    }
}

class Pair {
    public TreeNode node;
    public Character dir;
    public Integer parent;
}
