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
    
    public int rob(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Decision decision = makeDecision(root);
        return Math.max(decision.toTake,decision.orNotToTake);
    }
 
    public Decision makeDecision(TreeNode root){
        if(root == null){
            Decision decision = new Decision();
            return decision;
        }
 
        Decision result = new Decision();
        Decision left = makeDecision(root.left);
        Decision right = makeDecision(root.right);
  
        result.toTake = root.val + left.orNotToTake + right.orNotToTake;
        result.orNotToTake = Math.max(left.toTake, left.orNotToTake) + Math.max(right.toTake, right.orNotToTake);
 
        return result;
    }
}

class Decision {
    int toTake;
    int orNotToTake;
    
    public Decision() {
        toTake = 0;
        orNotToTake = 0;
    }
    
}

