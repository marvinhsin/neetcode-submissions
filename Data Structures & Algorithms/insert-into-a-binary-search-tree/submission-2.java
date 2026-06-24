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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        // TreeNode cur = root;
        // insert(root, Integer.MAX_VALUE, Integer.MIN_VALUE, val);
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val && root.left != null) {
            insertIntoBST(root.left, val);
        }
        else if (val > root.val && root.right != null) {
            insertIntoBST(root.right, val);
        }
        else if (val > root.val && root.right == null) {
            root.right = new TreeNode(val);
        }
        else if (val < root.val && root.left == null) {
            root.left = new TreeNode(val);
        }

        return root;
    }

    // public void insert(TreeNode root, int upper, int lower, int val) {
    //     if (val > root.val && root.right != null) {
    //         insert(root.right, upper, root.val, val);
    //     } else if (val < root.val && root.left != null) {
    //         insert(root.right, root.val, upper, val);
    //     }


    // }
}