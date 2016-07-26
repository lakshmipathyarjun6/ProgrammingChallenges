/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return null;
        }
        
        ListNode slowRunner = head;
        ListNode fastRunner = head.next;
        
        while(fastRunner != null) {
            if(fastRunner.val == slowRunner.val) {
                slowRunner.next = fastRunner.next;
            }
            else {
                slowRunner = slowRunner.next;
            }
            fastRunner = fastRunner.next;
        }
        
        return head;
    }
}
