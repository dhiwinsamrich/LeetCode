/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode preTail = null;        // stores the tail node of previous LL.
        ListNode curHead = head;        // stores the head node of current LL
        ListNode curTail = head;        // stores the tail node of current LL

        ListNode nextHead = null;       // stores the head node of next LL

        while(curHead != null)
        {
            // initialize count from 1
            int count = 1;

            // iterate the LL untill count becomes k or we reach the last node.
            while(curTail.next != null && count < k)
            {
                curTail = curTail.next;
                count++;
            }

            if(count != k)
            {
                break;
            }
            
            // set the nextHead pointer to the head of the next LL.
            nextHead = curTail.next;


            // detach the RHS of the current LL.
            curTail.next = null;

            // detach the LHS of the current LL.
            if(preTail != null)
            {
                preTail.next = null;
            }

            // after reversing the current LL, curHead becomes the new tail.
            // and curTail becomes the new head.

            curTail = reverse(curHead);

            // attach the LHS
            if(preTail != null)
            {
                preTail.next = curTail;
            }
            else
            {
                // if preTail is null then we have reversed the first LL
                // so store the reference of curHead in original head pointer.
                head = curTail;
            }

            // attach the RHS
            curHead.next = nextHead;
            
            // update the pointer
            preTail = curHead;
            curHead = nextHead;
            curTail = nextHead;
        }

        return head;
        
    }
    private ListNode reverse(ListNode head)
    {
        ListNode preNode = null;
        ListNode curNode = head;

        ListNode nextNode = head;

        while(curNode != null)
        {
            nextNode = nextNode.next;
            
            curNode.next = preNode;

            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }
}