/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        
        while(head != null && head.val == val) {
            head = head.next;
        }
        
        ListNode runner = head;
        
        while(runner != null) {
            if(runner.next != null && runner.next.val == val) {
                ListNode nextNode = runner.next;
                while(nextNode != null && nextNode.val == val) {
                    nextNode = nextNode.next;
                }
                runner.next = nextNode;
            }
            runner = runner.next;
        }
        
        return head;
    }
}