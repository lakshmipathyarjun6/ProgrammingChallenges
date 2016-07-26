/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }
        
        ListNode tail = head;
        ListNode toMove = tail.next;
        
        while(toMove != null) {
            if(toMove.val >= tail.val) {
                tail = toMove;
            }
            else {
                ListNode runner = head;
                ListNode dragging = null;
                while(runner.val < toMove.val) {
                    dragging = runner;
                    runner = runner.next;
                }
                if(runner == head) {
                    head = toMove;
                }
                else {
                    dragging.next = toMove;
                }
                tail.next = toMove.next;
                toMove.next = runner;
            }
            toMove = tail.next;
        }
        
        return head;
    }
}
