/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode oddStart = head;
        ListNode evenStart = head.next;
        
        ListNode oddConnector = oddStart;
        ListNode evenConnector = evenStart;
        
        while(evenConnector != null && evenConnector.next != null) {
            oddConnector.next = evenConnector.next;
            oddConnector = oddConnector.next;
            
            evenConnector.next = oddConnector.next;
            evenConnector = evenConnector.next;
        }
        
        oddConnector.next = evenStart;
        return head;
    }
}