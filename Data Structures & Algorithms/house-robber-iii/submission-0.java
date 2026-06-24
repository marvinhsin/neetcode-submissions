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
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftTree = dfs(root.left);
        int[] rightTree = dfs(root.right);
        int withRoot = root.val + leftTree[1] + rightTree[1];
        int withoutRoot = Math.max(leftTree[0], leftTree[1]) + Math.max(rightTree[0], rightTree[1]);

        return new int[]{withRoot, withoutRoot};
    }
}