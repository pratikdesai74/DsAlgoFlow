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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        ListNode fast=head;
        ListNode slow=head;

        if(lengthOfLinkedList(head)==n){
            ListNode temp=head.next;
           // head.next=null;
            return temp;
        }
            
        
        for(int i=0;i<n;i++){
            fast=fast.next;
        }

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        slow.next=slow.next.next;


        return head;
    }

    public int lengthOfLinkedList(ListNode head){
        int length=0;
        ListNode temp= head;

        while(temp!=null){
            length++;
            temp=temp.next;
        }
        return length; 
    }
}