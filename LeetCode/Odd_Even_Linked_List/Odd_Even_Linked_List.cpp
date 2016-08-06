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
    ListNode* oddEvenList(ListNode* head) {
        if(head == NULL || head->next == NULL) {
            return head;
        }
        ListNode* oddStart = head;
        ListNode* evenStart = head->next;
        ListNode* oddConnector = oddStart;
        ListNode* evenConnector = evenStart;
        
        while(evenConnector != NULL && evenConnector->next != NULL) {
            oddConnector->next = evenConnector->next;
            oddConnector = oddConnector->next;
            
            evenConnector->next = oddConnector->next;
            evenConnector = evenConnector->next;
        }
        
        oddConnector->next = evenStart;
        return head;
    }
};

