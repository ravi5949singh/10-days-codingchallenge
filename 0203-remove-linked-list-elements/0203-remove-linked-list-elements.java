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
    public ListNode removeElements(ListNode head, int val) {
         ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next; // Unlink/skip the current node
            } else {
                prev = curr;           // Only advance prev if we didn't delete a node
            }
            curr = curr.next;          // Move curr forward in every iteration
        }
        
        return dummy.next;
    }
}