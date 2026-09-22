
class Solution {
    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode smallhead = null;
        ListNode smalltail = null;

        ListNode Largehead = null;
        ListNode Largetail = null;

        ListNode curr = head;

        while (curr != null) {

            if (curr.val < x) {

                if (smallhead == null) {
                    smallhead = curr;
                    smalltail = curr;
                } else {
                    smalltail.next = curr;
                    smalltail = curr;
                }

            } else {

                if (Largehead == null) {
                    Largehead = curr;
                    Largetail = curr;
                } else {
                    Largetail.next = curr;
                    Largetail = curr;
                }
            }

            curr = curr.next;
        }

        // Very important
        if (smallhead == null) {
            return Largehead;
        }

        // Connect small list with large list
        smalltail.next = Largehead;

        // Break old connection
        if (Largetail != null) {
            Largetail.next = null;
        }

        return smallhead;
    }
}
