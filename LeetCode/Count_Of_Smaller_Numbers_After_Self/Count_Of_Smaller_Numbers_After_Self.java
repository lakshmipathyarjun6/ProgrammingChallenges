public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        Integer[] ans = new Integer[nums.length];
        Node root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, ans, i, 0);
        }
        return Arrays.asList(ans);
    }
    
    private Node insert(int num, Node node, Integer[] ans, int i, int preSum) {
        if (node == null) {
            node = new Node(num, 0);
            ans[i] = preSum;
        } 
        else if (node.val == num) {
            node.dup++;
            ans[i] = preSum + node.sum;
        } 
        else if (node.val > num) {
            node.sum++;
            node.left = insert(num, node.left, ans, i, preSum);
        } 
        else {
            node.right = insert(num, node.right, ans, i, preSum + node.dup + node.sum);
        }
        return node;
    }
}

class Node {
    Node left;
    Node right;
    int val;
    int sum;
    int dup;
    public Node(int v, int s) {
        left = null;
        right = null;
        val = v;
        sum = s;
        dup = 1;
    }
}
