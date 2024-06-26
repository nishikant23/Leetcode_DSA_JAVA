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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        
        if(root == null) return;
        flatten(root.right);
        flatten(root.left);

        root.right = prev;
        root.left = null;
        prev = root;
        System.out.println(" prev="+prev.val);
    }
    // public void f(TreeNode root, List<Integer> ls) {
    //     if(root == null) return;

    //     ls.add(root.val);
    //     f(root.left, ls);
    //     f(root.right, ls);
    // }
    // public TreeNode a(List<Integer> ls, int i) {
    //     if(i >= ls.size()) return null;
    //     TreeNode root = new TreeNode(ls.get(i));
    //     root.left = null;
    //     root.right = a(ls, i+1);

    //     return root;
    // }
}