#include <time.h> 

class Solution {
public:
    ListNode* start;
    /** @param head The linked list's head. Note that the head is guanranteed to be not null, so it contains at least one node. */
    Solution(ListNode* head) {
        start = head;
        ListNode* runner = start;
        while(runner != NULL) {
            size++;
            runner = runner->next;
        }
        srand (time(NULL));
    }
    
    /** Returns a random node's value. */
    int getRandom() {
        int randomNum = rand() % size;
        int index = 0;
        ListNode* runner = start;
        while(index < randomNum) {
            index++;
            runner = runner->next;
        }
        return runner->val;
    }
private:
    int size = 0;
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
