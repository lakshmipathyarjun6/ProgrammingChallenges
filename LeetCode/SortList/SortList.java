/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
 
        // count total number of elements
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
 
        // break up to two list
        int middle = count / 2;
 
        ListNode l = head;
        ListNode r = null;
        ListNode p2 = head;
        int countHalf = 0;
        while (p2 != null) {
            countHalf++;
            ListNode next = p2.next;
 
            if (countHalf == middle) {
                p2.next = null;
                r = next;
            }
            p2 = next;
        }
 
        // now we have two parts l and r, recursively sort them
        ListNode h1 = sortList(l);
        ListNode h2 = sortList(r);
 
        // merge together
        ListNode merged = merge(h1, h2);
 
        return merged;
    }
    
    public ListNode merge(ListNode l1, ListNode l2) {
        
        ListNode head;
        ListNode runner;
        
        if(l1 == null && l2 == null) {
            return null;
        }
        
        else if(l1 == null) {
            head = l2;
        }
        
        else if(l2 == null) {
            head = l1;
        }
        
        else {
            if (l1.val < l2.val) {
                head = l1;
                l1 = l1.next;
            } 
            else {
                head = l2;
                l2 = l2.next; 
            }
            runner = head;
            
            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    runner.next = l1;
                    l1 = l1.next;
                }
                else {
                    runner.next = l2;
                    l2 = l2.next;
                }
                runner = runner.next;
            }
            
            if(l1 == null) {
                runner.next = l2;
            }
            else {
                runner.next = l1;
            }
        }
        return head;
    }
}
