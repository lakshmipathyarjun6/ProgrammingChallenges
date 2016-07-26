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
        Stack<Integer> sum = new Stack<Integer>();
        
        ListNode l1Runner = l1;
        ListNode l2Runner = l2;
        
        int carry = 0;
        
        while(l1Runner != null || l2Runner != null) {
            if(l1Runner == null) {
                int sumVal = l2Runner.val + carry;
                if(sumVal >= 10) {
                    sum.push(sumVal % 10);
                    carry = 1;
                }
                else {
                    sum.push(sumVal);
                    carry = 0;
                }
                l2Runner = l2Runner.next;
            }
            else if(l2Runner == null) {
                int sumVal = l1Runner.val + carry;
                if(sumVal >= 10) {
                    sum.push(sumVal % 10);
                    carry = 1;
                }
                else {
                    sum.push(sumVal);
                    carry = 0;
                }
                l1Runner = l1Runner.next;
            }
            else {
                int sumVal = l1Runner.val + l2Runner.val + carry;
                if(sumVal >= 10) {
                    sum.push(sumVal % 10);
                    carry = 1;
                }
                else {
                    sum.push(sumVal);
                    carry = 0;
                }
                l1Runner = l1Runner.next;
                l2Runner = l2Runner.next;
            }
        }
        
        if(carry == 1) {
            sum.push(1);
        }
        
        ListNode nextVal = null;
        
        while(!sum.empty()) {
            ListNode current = new ListNode(sum.pop());
            current.next = nextVal;
            nextVal = current;
        }
        
        return nextVal;
    }
}