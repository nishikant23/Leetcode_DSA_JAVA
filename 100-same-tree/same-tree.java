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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return f(p,q);

    }
    private boolean f(TreeNode p, TreeNode q){
        if(p == null && q == null) return true; //Both tree identical in Ht.-wise on left&right
        if(p == null || q == null) return false; //eiter of leftORright tree-hts not same
        if(p.val != q.val) return false; //atATime check left-left p&q value & viceVersa Right

        return f(p.left, q.left) && f(p.right, q.right); //1st-f(p.l, q.l) complete first till p&q==null found, then there cnd-1,2,3 chack then, 2ndly-f(p.r, q.r) function calls vice versa
    }
}