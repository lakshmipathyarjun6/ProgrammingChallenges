/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        List<String> ls = new LinkedList<String>();
        
        while(queue.size() != 0) {
            TreeNode node = queue.remove();
            
            if(node == null) {
                ls.add("null");
            }
            else {
                ls.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        StringBuffer buff = new StringBuffer();
        
        for(String s : ls) {
            buff.append(s);
            buff.append(" ");
        }
        
        return buff.toString().trim();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] partitionedData = data.split("\\s+");
        System.out.println(Arrays.toString(partitionedData));
        
        TreeNode [] nodes = new TreeNode[partitionedData.length];
        
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = (partitionedData[i].equals("null")) ? null : new TreeNode(Integer.parseInt(partitionedData[i]));
        }
        
        int nodeIndex = 0;
        for(int i = 0; i < nodes.length; i++) {
            TreeNode node = nodes[i];
            if(node != null) {
                int leftIndex = 2*nodeIndex + 1;
                int rightIndex = 2*nodeIndex + 2;
                
                node.left = (leftIndex < nodes.length) ? nodes[leftIndex] : null;
                node.right = (rightIndex < nodes.length) ? nodes[rightIndex] : null;
                
                nodeIndex++;
            }
        }
        
        return nodes[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
