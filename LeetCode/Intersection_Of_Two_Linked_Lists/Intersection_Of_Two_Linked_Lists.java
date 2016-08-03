/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        ListNode aRunner = headA;
        ListNode bRunner = headB;
        
        int aSize = 0;
        while(aRunner != null) {
            aSize++;
            aRunner = aRunner.next;
        }
        int bSize = 0;
        while(bRunner != null) {
            bSize++;
            bRunner = bRunner.next;
        }
        aRunner = headA;
        bRunner = headB;
        
        while(aSize > bSize) {
            aRunner = aRunner.next;
            aSize--;
        }
        while(bSize > aSize) {
            bRunner = bRunner.next;
            bSize--;
        }
        
        while(aRunner != null && bRunner != null) {
            if(aRunner == bRunner) {
                return aRunner;
            }
            aRunner = aRunner.next;
            bRunner = bRunner.next;
        }
        return null;
    }
}
