/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumHead = new ListNode(0);
        ListNode sumRunner = sumHead;
        
        ListNode l1Runner = l1;
        ListNode l2Runner = l2;
        
        int carry = 0;
        
        while(l1Runner != null || l2Runner != null) {
            int sumVal = carry + ((l1Runner == null) ? l2Runner.val : ((l2Runner == null) ? l1Runner.val : l1Runner.val + l2Runner.val));
            ListNode nextVal = new ListNode(sumVal % 10);
            carry = (sumVal >= 10) ? 1 : 0;
            if(l1Runner == null) {
                l2Runner = l2Runner.next;
            }
            else if(l2Runner == null) {
                l1Runner = l1Runner.next;
            }
            else {
                l1Runner = l1Runner.next;
                l2Runner = l2Runner.next;
            }
            sumRunner.next = nextVal;
            sumRunner = sumRunner.next;
        }
        
        if(carry == 1) {
            sumRunner.next = new ListNode(1);
            sumRunner = sumRunner.next;
        }

        return sumHead.next;
    }
}
