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
                ListNode e=head;

                while(e!=slow){
                    e=e.next;
                    slow=slow.next;
                }
                return e;
            }
        }

        return null;
    }
}