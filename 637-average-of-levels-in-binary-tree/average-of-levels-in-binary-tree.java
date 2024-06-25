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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ls = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        double avg = 0;
        while(!q.isEmpty()){
            double sum = 0;
            int size = q.size();
            for(int  i=0; i<size; i++) {
                TreeNode x = q.poll();
                sum += x.val;
                if(x.left != null) q.add(x.left);
                if(x.right != null) q.add(x.right);
            }
            avg = sum/size;
            ls.add(avg);
            System.out.println("y="+size+" sum="+sum+" avg="+avg);   
        }
    return ls;
    }
}