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
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) return true;

        return isMirror(root.left,root.right); //simultaneous chk of lft & rght tree nodes
    }

    public boolean isMirror(TreeNode lf, TreeNode rt) {
        if(lf == null && rt == null) return true;
        if(lf == null || rt == null) return false;

        return ((lf.val == rt.val) && isMirror(lf.left, rt.right) && isMirror(lf.right, rt.left));

    }
}