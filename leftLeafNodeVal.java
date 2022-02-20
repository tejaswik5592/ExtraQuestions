// Time Complexity :O(n), where n = no. of nodes
// Space Complexity :O(h), where h=height of tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// DFS solution with an inorder traversal, I use a flag to indicate that its a left child
class Solution {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        sum=0;
        dfs(root, false);
        return sum;
    }

    private void dfs(TreeNode root, boolean flag) {
        //base
        if (root == null) return;

        //logic
        if (root.left != null) {
            dfs(root.left, true);
        }
        if (flag && root.left == null && root.right == null) {
            sum += root.val;
        }
        dfs(root.right, false);
    }
}