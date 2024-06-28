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
    public TreeNode sortedArrayToBST(int[] nums) {
        return f(nums, 0, nums.length-1);
    }
    public TreeNode f(int[] arr, int l, int r){

        if(l>r) return null;
        int m = l + (r-l)/2;

        TreeNode root = new TreeNode(arr[m]);

        root.left = f(arr, l, m-1);
        root.right = f(arr, m+1, r);

        return root;
    }
}