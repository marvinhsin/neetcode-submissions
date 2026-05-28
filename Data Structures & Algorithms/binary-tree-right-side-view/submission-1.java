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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<Pair<Integer, TreeNode>> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        queue.add(new Pair<>(1, root));
        int cur_level = 1;
        while (!queue.isEmpty()) {
            Pair<Integer, TreeNode> front = queue.poll();
            int level = front.getKey();
            TreeNode node = front.getValue();
            if (cur_level == level) {
                res.add(node.val);
                cur_level++;
            }
            if (node.right != null) {
                queue.add(new Pair<>(level + 1, node.right));
            }
            if (node.left != null) {
                queue.add(new Pair<>(level + 1, node.left));
            }
        }
        return res;
    }
}
