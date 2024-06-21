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
    public int maxDepth(TreeNode root) {

       return  solve(root, 0);
    }

    public int solve(TreeNode root, Integer cnt){

        Stack<Integer> st = new Stack<>();

        if(root == null){
           return cnt;
        }
 
        return Math.max(solve(root.left, cnt+1), solve(root.right, cnt+1));
    }
}