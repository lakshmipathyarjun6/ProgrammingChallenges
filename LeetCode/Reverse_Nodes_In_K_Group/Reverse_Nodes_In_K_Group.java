/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null||k==1)
            return head;
        
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        int i=0;
        
        ListNode p = head;
        while(p!=null){
            i++;
            if(i%k==0){
                pre = reverseList(pre, p.next);
                p = pre.next;
            }
            else{
                p = p.next;
            }
        }
        
        return fake.next;
    }
    
    public ListNode reverseList(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode curr = last.next;
        
        while(curr != next){
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }
        
        return last;
    }
    
}