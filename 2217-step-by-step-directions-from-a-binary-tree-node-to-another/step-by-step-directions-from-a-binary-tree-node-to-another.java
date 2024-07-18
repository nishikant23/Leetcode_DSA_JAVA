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
    public String getDirections(TreeNode root, int sv, int dv) {
        root = lca(root, sv, dv);
        StringBuilder path1 = new StringBuilder(); 
        StringBuilder path2= new StringBuilder(); 

        pathFind(root, sv, path1);
        pathFind(root, dv, path2);

        for(int i=0; i<path1.length(); i++)
            path1.setCharAt(i, 'U');
        
        return path1.append(path2).toString();
    }
    public boolean pathFind(TreeNode root, int val, StringBuilder path){
        if(root == null) return false;
        if(root.val == val) return true;

        path.append('L');
        if(pathFind(root.left, val, path)) return true;
        path.deleteCharAt(path.length()-1);

        path.append('R');
        if(pathFind(root.right, val, path)) return true;
        path.deleteCharAt(path.length()-1);

        return false;
    }
    public TreeNode lca(TreeNode root, int p, int q){
        if(root==null || root.val == p || root.val == q){
            return root;
        }
        TreeNode left = lca(root.left, p , q);
        TreeNode right = lca(root.right, p, q);

        if(left == null) return right; //if left=null then return right node
        else if(right == null) return left; //right==null return left only
        else return root; //if both left & right had node then its parent return = LCA
    }
}