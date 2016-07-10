/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode runner= head;
        
        while(runner != null) {
            stack.push(runner);
            runner = runner.next;
        }
        
        ListNode finalList = null;
        ListNode previous = stack.pop();
        boolean isDuplicate = false;
        
        while(!stack.empty()) {
            while(stack.peek().val == previous.val) {
                isDuplicate = true;
                stack.pop();
                if(stack.empty()) {
                    break;
                }
            }
            if(!isDuplicate) {
                previous.next = finalList;
                finalList = previous;
            }
            previous = (!stack.empty()) ? stack.pop() : null;
            isDuplicate = false;
        }
        
        if(previous != null) {
            previous.next = finalList;
            finalList = previous;
        }
        
        return finalList;
    }
}
