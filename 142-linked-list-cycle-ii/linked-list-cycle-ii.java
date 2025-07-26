/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;

        ListNode fast=head;
        ListNode slow=head;

        while(fast.next!=null && fast.next.next !=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){
                // as it has loop creating new pointer staring from head
                ListNode entry=head;

                // we will shift both slow pointer and entry pointer by 1 node from their
                // current position until they meet
                // that meeting position node is the where the cycle started
                while(entry!=slow){
                    entry=entry.next;
                    slow=slow.next;
                }
                return entry;
            }
        }

        return null;
    }
}