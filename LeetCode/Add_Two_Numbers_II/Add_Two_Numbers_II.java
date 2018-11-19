/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode l) {
        Stack<ListNode> s = new Stack<ListNode>();
        
        ListNode runner = l;
        while(runner != null) {
            s.push(runner);
            runner = runner.next;
        }
        
        ListNode res = new ListNode(0);
        ListNode lRunner = res;
        
        while(!s.empty()) {
            lRunner.next = s.pop();
            lRunner = lRunner.next;
        }
        
        lRunner.next = null;

        return res.next;
    }
    
    public int getValueAtIndex(ListNode l, int index) {
        int ctr = 0;
        ListNode lRunner = l;
        while(ctr < index-1) {
            lRunner = lRunner.next;
            ctr++;
        }
        return lRunner.val;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int size_l1 = 0;
        int size_l2 = 0;
        ListNode l1Runner = l1;
        ListNode l2Runner = l2;
        
        while(l1Runner != null) {
            size_l1++;
            l1Runner = l1Runner.next;
        }
        while(l2Runner != null) {
            size_l2++;
            l2Runner = l2Runner.next;
        }

        int index1 = size_l1;
        int index2 = size_l2;
        
        ListNode result = new ListNode(0);
        ListNode currentNode = result;
        
        int carry = 0;
        while(index1 > 0 || index2 > 0) {
            int value = 0;
            
            int l1NodeVal = (index1 > 0) ? getValueAtIndex(l1,index1) : 0;
            int l2NodeVal = (index2 > 0) ? getValueAtIndex(l2,index2) : 0;
            value = l1NodeVal + l2NodeVal + carry;
            if(value >= 10) {
                value %= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            
            index1--;
            index2--;
            currentNode.next = new ListNode(value);
            currentNode = currentNode.next;
        }
        if(carry == 1) {
            currentNode.next = new ListNode(1);
            currentNode = currentNode.next;
        }
        
        result = reverseList(result.next);
        
        return result;
    }
}
