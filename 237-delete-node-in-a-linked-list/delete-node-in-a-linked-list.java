/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // it is not possible to delete node, if we dont have address of previous node or head node
        // so we are copying next node value and deleteing next node
        node.val=node.next.val;
        node.next=node.next.next;
    }
}