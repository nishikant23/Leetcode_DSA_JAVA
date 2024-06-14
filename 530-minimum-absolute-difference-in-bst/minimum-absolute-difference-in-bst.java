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
    int ans  = Integer.MAX_VALUE;
    Integer prevRoot = null; //keep track of each prev node 
    public int getMinimumDifference(TreeNode root) {
        find(root);
        return ans;
    }

    private void find(TreeNode root) {
        
        if(root == null) return;

        find(root.left);  //left side
 
        if(prevRoot != null) {
            ans = Math.min(ans, Math.abs(root.val - prevRoot));
        }

        prevRoot = root.val; // Inorder traversal
        
        find(root.right);  //Right side
       //System.out.println("Curr Root- "+root.val+" Prev Root- "+prevRoot);
        
    }
}