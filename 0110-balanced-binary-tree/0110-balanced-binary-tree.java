/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    private static int height(TreeNode node){
        if(node == null) return 0;
        int leftans = height(node.left);
        if(leftans == -1) return -1;
        
        int rightans = height(node.right);
        if(rightans == -1) return -1;

        if(Math.abs(leftans - rightans) > 1) return -1;

        return Math.max(leftans,rightans) +1;
    }
}