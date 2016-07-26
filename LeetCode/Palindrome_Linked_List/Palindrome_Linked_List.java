/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) {
            return true;
        }
        
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if(fast != null) {
            slow = slow.next;
        }
        
        while(slow != null) {
            ListNode compareNode = stack.pop();
            if(compareNode.val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        
        return true;
    }
}