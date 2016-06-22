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
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        
        ListNode* head;
        ListNode* runner;
        
        if(l1 == NULL && l2 == NULL) {
            return NULL;
        }
        
        else if(l1 == NULL) {
            head = l2;
        }
        
        else if(l2 == NULL) {
            head = l1;
        }
        
        else {
            if (l1->val < l2->val) {
                head = l1;
                l1 = l1->next;
            }
            else {
                head = l2;
                l2 = l2->next;
            }
            runner = head;
            
            while(l1 != NULL && l2 != NULL) {
                if(l1->val < l2->val) {
                    runner->next = l1;
                    l1 = l1->next;
                }
                else {
                    runner->next = l2;
                    l2 = l2->next;
                }
                runner = runner->next;
            }
            
            if(l1 == NULL) {
                runner->next = l2;
            }
            else {
                runner->next = l1;
            }
        }
        return head;
    }
};