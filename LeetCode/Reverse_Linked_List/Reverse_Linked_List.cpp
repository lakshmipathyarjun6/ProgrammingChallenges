/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if(head == NULL) {
            return head;
        }
        
        stack<ListNode*> nodeStack;
        ListNode* runner = head;
        while(runner != NULL) {
            nodeStack.push(runner);
            runner = runner->next;
        }
        head = nodeStack.top();
        
        while(!nodeStack.empty()) {
            ListNode* node = nodeStack.top();
            nodeStack.pop();
            if(nodeStack.empty()) {
               node->next = NULL;
            }
            else {
                node->next = nodeStack.top();
            }
        }
        
        return head;
    }
};

