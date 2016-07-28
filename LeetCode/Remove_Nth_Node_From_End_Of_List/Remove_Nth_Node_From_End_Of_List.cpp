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
    ListNode* findNthNode(ListNode* head, int n) {
        ListNode* p1 = head;
        ListNode* p2 = head;
        
        for(int i = 0; i < n - 1; i++) {
            p2 = p2->next;
        }
        
        while(p2->next != NULL) {
            p1 = p1->next;
            p2 = p2->next;
        }
        
        return p1;
    }
    
    void removeNode(ListNode* head, ListNode* nthNode) {
        ListNode* current = head;
        while(current->next != nthNode) {
            current = current->next;
        }
        current->next = nthNode->next;
    }

    ListNode* removeNthFromEnd(ListNode* head, int n) {
        ListNode* nthNode = findNthNode(head,n);
        if(nthNode == head) {
            head = head->next;
        }
        else {
            removeNode(head,nthNode);
        }
        return head;
    }
};
