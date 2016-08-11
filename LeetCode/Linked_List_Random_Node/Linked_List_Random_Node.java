import java.util.Random;

public class Solution {
    
    ListNode start;
    private int size = 0;
    
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        start = head;
        ListNode runner = start;
        while(runner != null) {
            size++;
            runner = runner.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        Random rand = new Random();
        int randomNum = rand.nextInt(size);
        int index = 0;
        ListNode runner = start;
        while(index < randomNum) {
            index++;
            runner = runner.next;
        }
        return runner.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
