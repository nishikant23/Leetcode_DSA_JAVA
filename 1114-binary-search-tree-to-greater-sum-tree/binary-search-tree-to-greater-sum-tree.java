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
    int sum= 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;

        bstToGst(root.right);
        TreeNode par = new TreeNode(root.val);
        if(root.val >= par.val) sum += root.val; 
        System.out.println("Sum is "+sum+" -Root: "+root.val);
        root.val = sum;
        bstToGst(root.left);
    
        return root;
    }
}