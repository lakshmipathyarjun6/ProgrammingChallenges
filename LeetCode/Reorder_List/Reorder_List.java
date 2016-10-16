/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        Queue<ListNode> firstHalf = new LinkedList<ListNode>();
        Stack<ListNode> secondHalf = new Stack<ListNode>();
        
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        
        while(fastRunner.next != null) {
            firstHalf.offer(slowRunner);
            fastRunner = fastRunner.next.next;
            if(fastRunner == null) {
                break;
            }
            slowRunner = slowRunner.next;
        }
        
        if(fastRunner != null && fastRunner.next == null) {
            firstHalf.offer(slowRunner);
        }
        slowRunner = slowRunner.next;
        
        while(slowRunner != null) {
            secondHalf.push(slowRunner);
            slowRunner = slowRunner.next;
        }
        
        ListNode runner = new ListNode(0);
        head = runner;
        boolean alternate = true;
        while(runner != null) {
            runner.next = (alternate) ? ((firstHalf.size() > 0) ? firstHalf.poll() : null) : ((secondHalf.size() > 0) ? secondHalf.pop() : null);
            runner = runner.next;
            alternate = !alternate;
        }
        
        head = head.next;
    }
}
