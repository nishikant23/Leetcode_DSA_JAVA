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
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;

        convertBST(root.right); //go till rightmost, 
        TreeNode par = new TreeNode(root.val);
        sum += root.val; // all roots sum b4 curr rightmost root
        //System.out.println("Sum is "+sum+" -Root: "+root.val);
        root.val = sum; //curr root value update to sum
        convertBST(root.left); //go like this till leftmost 
    
        return root; //original root updated and return
    }
}