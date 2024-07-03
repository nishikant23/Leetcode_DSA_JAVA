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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ls = new ArrayList<>();
        find(root, ls, new StringBuilder());
        return ls;
    }
    public void find(TreeNode root, List<String> ls, StringBuilder sb) {
        if(root==null) return;

        int len = sb.length();
        sb.append(root.val);

        if(root.left == null && root.right == null){
            ls.add(sb.toString());
        } else {
            sb.append("->");
            find(root.left, ls, sb);
            find(root.right, ls, sb);
         }
         sb.setLength(len); //By using sb.setLength(len);, we set the length of the StringBuilder back to its previous state (before the recursive call). This effectively removes the last part of the path string that was added for the current node.
    }
        
}