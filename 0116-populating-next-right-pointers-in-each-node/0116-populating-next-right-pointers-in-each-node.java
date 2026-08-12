class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null; // Fixed: returned null instead of 0
        }
             
        Node leftmost = root; // Fixed: Node instead of TreeNode

        while (leftmost.left != null) { // Fixed: typo 'whike'
            Node curr = leftmost; // Fixed: Node instead of TreeNode

            while (curr != null) { // Fixed: condition changed from curr.next != null
                // Connect left child to right child
                curr.left.next = curr.right;

                // Connect right child to adjacent subtree's left child
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                // Move to next node in the current level
                curr = curr.next;
            }

            // Move to the next level down
            leftmost = leftmost.left;
        }

        return root;
    }
}