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
    public int sumNumbers(TreeNode root) {
       return sum(root, 0);
    }

    public int sum(TreeNode root, int res){
        if(root == null) return 0;

        res = res + root.val;
        if (root.left == null && root.right == null)  //Single node case 
            return res; //that single node value itself return

        return sum(root.left, res*10) + sum(root.right, res*10); // left branch+right branch like this goes addn.
    }
}