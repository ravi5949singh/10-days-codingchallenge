class Solution {
    
    int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int[] inorder, int start, int end) {

        if (start > end) {
            return null;
        }

        // Preorder se root lo
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // Inorder me root ka index find karo
        int index = start;

        while (inorder[index] != root.val) {
            index++;
        }

        // Left subtree
        root.left = build(preorder, inorder, start, index - 1);

        // Right subtree
        root.right = build(preorder, inorder, index + 1, end);

        return root;
    }
}