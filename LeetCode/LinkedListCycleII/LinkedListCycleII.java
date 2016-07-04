/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fastrunner = head;
        ListNode slowrunner = head;
        
        while(fastrunner != null && slowrunner != null) {
            slowrunner = slowrunner.next;
            fastrunner = fastrunner.next;
            if(fastrunner != null)
                fastrunner = fastrunner.next;
            if(fastrunner == slowrunner)
                break;
        }
        
        if(fastrunner == null) {
            return null;
        }
        
        slowrunner = head;
        
        while(fastrunner != slowrunner) {
            fastrunner = fastrunner.next;
            slowrunner = slowrunner.next;
        }
        
        return fastrunner;
    }
}
