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
    int ans=0;
    public int countPairs(TreeNode root, int d) {
        help(d, root);
        return ans;
        
    }
    public List<Integer> help(int d, TreeNode root) {
        if(root == null) return new ArrayList<>();
        if(root.left == null && root.right == null) return Arrays.asList(1);

        List<Integer> l = help(d, root.left);
        List<Integer> r = help(d, root.right);

        for(int a : l){
            for(int b : r) {
                if(a+b <= d) ans++;
            }
        }

        List<Integer> ret = new ArrayList<>();
        for(int a : l) {
            if(a+1 < d) ret.add(a+1);
        }
        for(int b : r) {
            if(b+1 < d) ret.add(b+1);
        }

        return ret;

    }
}