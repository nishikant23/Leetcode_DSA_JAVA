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
    public boolean isValidBST(TreeNode root) {
        //if(root.left == null && root.right == null) return true;
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root,Integer min, Integer max){
        if(root == null) {      
            return true;
        }
        //the root.val=current && max&min = acts as prev rootvalue 
        if((min != null && root.val <= min) || (max != null && root.val >= max)) return false;

        boolean l = isValidBST(root.left, min, root.val); // root.val pass as prev node  = max 
        boolean r = isValidBST(root.right, root.val, max); // root.val pass as prev node  = min

        return l && r; //if both left&right side satisfy condtn. ==true ; flase
    }
}