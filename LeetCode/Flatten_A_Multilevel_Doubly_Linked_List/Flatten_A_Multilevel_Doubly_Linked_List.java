/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if(head == null) {
            return head;
        }
        Node runner = head;
        
        while(runner != null) {
            if(runner.child != null) {
                Node childStart = flatten(runner.child);
                childStart.prev = runner;
                Node childRunner = childStart;
                while(childRunner != null && childRunner.next != null) {
                    childRunner = childRunner.next;
                }
                childRunner.next = runner.next;
                if(runner.next != null) {
                    runner.next.prev = childRunner;
                }
                runner.next = runner.child;
                runner.child = null;
                runner = childRunner.next;
            }  
            else {
                runner = runner.next;
            }
        }
        
        return head;
    }
}
