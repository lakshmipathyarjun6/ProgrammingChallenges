/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return head;
        }
        
        Stack<ListNode> nodeStack = new Stack<ListNode>();
        
        ListNode runner = head;
        while(runner != null) {
            nodeStack.push(runner);
            runner = runner.next;
        }
        
        head = nodeStack.peek();
        
        while(!nodeStack.isEmpty()) {
            ListNode node = nodeStack.pop();
            if(nodeStack.isEmpty()) {
                node.next = null;
            }
            else {
                node.next = nodeStack.peek();
            }
        }
        
        return head;
    }
}