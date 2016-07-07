/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0)
        return null;
 
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
 
        for(ListNode list: lists){
            if(list!=null) {
                queue.offer(list);
            }
        }
        
        ListNode head = null;
        ListNode runner = null;
        boolean firstTime = true;
        
        while(!queue.isEmpty()) {
            ListNode n = queue.poll();
            
            if(firstTime) {
                head = n;
                runner = head;
                firstTime = false;
            }
            else {
                runner.next = n;
                runner = runner.next;
            }
 
            if(n.next!=null) {
                queue.offer(n.next);
            }
        }
        
        return head;
    }
}
