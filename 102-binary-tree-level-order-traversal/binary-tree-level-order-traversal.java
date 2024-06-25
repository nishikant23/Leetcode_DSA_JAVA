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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
       
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){ List<Integer> ls = new ArrayList<>();
            int size = q.size();
            for(int  i=0; i<size; i++) { //remove from que till size
                TreeNode x = q.poll();
                if(x != null) ls.add(x.val);
                if(x != null && x.left != null) q.add(x.left); 
                if(x != null &&x.right != null) q.add(x.right);
            }
            ans.add(ls);
        }
        return ans;
    }
}