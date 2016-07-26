/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    private ListNode reverseList(ListNode head, ListNode tail) {
        if(head == null || head.equals(tail)) {
            return head;
        }
        
        Stack<ListNode> nodeStack = new Stack<ListNode>();
        
        ListNode runner = head;
        while(runner != tail) {
            nodeStack.push(runner);
            runner = runner.next;
        }
        
        head = nodeStack.peek();
        
        while(!nodeStack.isEmpty()) {
            ListNode node = nodeStack.pop();
            System.out.println(node.val);
            if(nodeStack.isEmpty()) {
                node.next = tail;
            }
            else {
                node.next = nodeStack.peek();
            }
        }
        
        return head;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }
        
        int nodePos = 1;
        ListNode runner = head;
        
        ListNode regionStart = null;
        ListNode regionEnd = null;
        ListNode beforeStart = null;
        
        while(nodePos <= n) {
            if(nodePos+1 == m) {
                beforeStart = runner;
            }
            else if(nodePos == m) {
                regionStart = runner;
            }
            nodePos++;
            runner = runner.next;
        }
        
        regionEnd = runner;
        
        if(beforeStart != null) {
            beforeStart.next = reverseList(regionStart,regionEnd);
        }
        else {
            head = reverseList(regionStart,regionEnd);
        }
        return head;
    }
}