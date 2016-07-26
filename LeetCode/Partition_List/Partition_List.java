/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }
        
        ListNode lesserHead = new ListNode(0);
        ListNode lesserRunner = lesserHead;
        
        ListNode greaterHead = new ListNode(0);
        ListNode greaterRunner = greaterHead;
        
        ListNode mainRunner = head;
        while(mainRunner != null) {
            ListNode n = new ListNode(mainRunner.val);
            if(n.val < x) {
                lesserRunner.next = n;
                lesserRunner = lesserRunner.next;
            }
            else {
                greaterRunner.next = n;
                greaterRunner = greaterRunner.next;
            }
            mainRunner = mainRunner.next;
        }
        
        lesserRunner.next = greaterHead.next;
        return lesserHead.next;
    }
}
