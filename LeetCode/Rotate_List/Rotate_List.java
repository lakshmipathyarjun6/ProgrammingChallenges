/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null) {
            return head;
        }
        
        int counter = 0;
        ListNode counterRunner = head;
        
        while(counterRunner != null) {
            counterRunner = counterRunner.next;
            counter++;
        }
        
        k = k % counter;
        
        if(k == 0) {
            return head;
        }
        
        ListNode start = head;
        ListNode end = head;
        
        while(k > 1) {
            end = end.next;
            k--;
        }
        while(end != null && end.next != null) {
            start = start.next;
            end = end.next;
        }
        
        end.next = head;
        
        ListNode runner = head;
        
        while(runner != null && runner.next != start) {
            runner = runner.next;
        }
        
        runner.next = null;
        return start;
    }
}