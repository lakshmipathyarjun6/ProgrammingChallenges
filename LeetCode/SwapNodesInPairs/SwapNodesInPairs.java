/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while(slow != null) {
            if(slow.next == null) {
                break;
            }
            fast = fast.next.next;
            slow.next.next = slow;
            if(slow.equals(head)) {
                head = slow.next;
            }
            slow.next = (fast == null || fast.next == null) ? fast : fast.next;
            slow = fast;
        }
        return head;
        
    }
}