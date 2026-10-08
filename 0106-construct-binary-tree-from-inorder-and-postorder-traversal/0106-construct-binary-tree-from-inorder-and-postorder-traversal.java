class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // Store inorder values and their indexes
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder,
                           int left, int right) {

        if (left > right) {
            return null;
        }

        // Last element of postorder is root
        int rootValue = postorder[postIndex--];

        TreeNode root = new TreeNode(rootValue);

        int index = map.get(rootValue);

        // IMPORTANT: Build right first
        root.right = build(inorder, postorder, index + 1, right);

        // Then build left
        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }
}