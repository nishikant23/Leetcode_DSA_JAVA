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
    int i=0;
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> ls = new ArrayList<>();
        f(root, ls); //in-order result store into list
        //Collections.sort(ls); // no need test cases designed such a way
        return bbst(ls, 0, ls.size()-1); //crt new Tree and returend
    }
    public void f(TreeNode root, List<Integer> ls) {
        if(root == null) return;
        f(root.left, ls);
        ls.add(root.val);
        f(root.right, ls);
    }
    public TreeNode bbst(List<Integer> ls, int l , int r) {
        
        if(l>r) return null;
        int m = l + (r-l)/2;
        TreeNode root  = new TreeNode(ls.get(m));
        root.left = bbst(ls, l, m-1);
        root.right = bbst(ls, m+1, r);
        return root;
    }
}