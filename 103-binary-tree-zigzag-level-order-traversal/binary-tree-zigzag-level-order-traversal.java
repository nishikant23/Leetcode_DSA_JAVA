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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       
         List<List<Integer>> ans = new ArrayList<>(); 
         if(root == null ) return ans;
         Queue<TreeNode> q = new LinkedList<>();
         q.add(root);
         while(!q.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i<size; i++){
                TreeNode x = q.poll();
                if(x != null) ls.add(x.val);
                if(x != null && x.left != null) q.add(x.left);
                if(x != null && x.right != null) q.add(x.right);
            }
            ans.add(ls);
         }
         for(int i=0; i<ans.size(); i++){
            if(i%2 != 0) {
                List<Integer> a = reverse(ans.get(i));
                ans.set(i, a);
            }
         }
         return ans;
    }
    public List<Integer> reverse(List<Integer> ls) {
        int l=0, r= ls.size()-1;
        while(l<r) {
            int t = ls.get(l);
            ls.set(l, ls.get(r));
            ls.set(r, t);
            l++;
            r--;
        }
        return ls;
    }
}