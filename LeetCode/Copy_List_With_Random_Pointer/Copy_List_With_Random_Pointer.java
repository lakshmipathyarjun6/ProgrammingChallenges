/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Stack<Integer> vals = new Stack<Integer>();
        Queue<Integer> randomPointerLocations = new LinkedList<Integer>();
        
        RandomListNode current = head;
        while(current != null) {
            vals.push(current.label);
            if (current.random != null) {
                randomPointerLocations.add(distanceFromStart(head, current.random));
            }
            else {
                randomPointerLocations.add(null);
            }
            current = current.next;
        }
        
        RandomListNode end = null;
        while(!vals.empty()) {
            RandomListNode node = new RandomListNode(vals.pop());
            node.next = end;
            end = node;
        }
        RandomListNode newHead = end;
        current = newHead;
        while(randomPointerLocations.size() != 0) {
            Integer location = randomPointerLocations.remove();
            current.random = (location == null) ? null : getNode(newHead,location);
            current = current.next;
        }
        
        return newHead;
    }
    
    private int distanceFromStart(RandomListNode head, RandomListNode node) {
        RandomListNode current = head;
        int distance = 0;
        while(current != node) {
            current = current.next;
            distance++;
        }
        return distance;
    }
    
    private RandomListNode getNode(RandomListNode head, int location) {
        RandomListNode current = head;
        int index = 0;
        while(index < location) {
            current = current.next;
            index++;
        }
        return current;
    }
}
