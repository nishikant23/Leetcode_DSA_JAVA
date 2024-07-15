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
    public TreeNode createBinaryTree(int[][] mat) {

        HashMap<Integer, TreeNode> map= new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int[] m : mat) { //sort way to get 2D arra cols value if row is only chnaging
            int parentVal = m[0];
            int childVal = m[1];
            int isLeft = m[2];

            TreeNode parentNode = map.getOrDefault(parentVal, new TreeNode(parentVal));
            TreeNode childNode = map.getOrDefault(childVal, new TreeNode(childVal)); 

            if(isLeft == 1){
                parentNode.left = childNode;
            }else {
                parentNode.right = childNode;
            }

            map.put(parentVal, parentNode);
            map.put(childVal, childNode);
            set.add(childVal);
        } //exit lopp-1

        for(int[] m : mat) {
            if(!set.contains(m[0])){
                return map.get(m[0]);
            }
        }

        return null;

        // int m=mat.length, n=mat[0].length;
        // TreeNode root = findRoot(mat, m, n); //Find Parent Node
        // createBt( root, mat, m, 0); //After root found create Binary Tree
        // return root;
    }
    // public TreeNode findRoot(int[][] mat, int m, int n){ // Root finder
    //     TreeNode root = null;
    //     for(int i=0; i<m; i++) {
    //         if(root != null) break;
    //         if(i>0 && mat[i][0] == mat[i][1]) continue;
    //         for(int j=0; j<m; j++) {
    //             if(mat[i][0] == mat[j][1]) break;
    //             if(j == m-1) {
    //                 System.out.println("Root is = "+mat[i][0]);
    //                 root = new TreeNode(mat[i][0]);
    //             }
    //         }
    //     }
    //     return root;
    // }
    // public void createBt(TreeNode root, int[][] mat, int m,  int ind){
    //     if(root.left == null && root.right == null  && ind > (m-1)) { //Leaves inital root.left & right ==nul chk, by ind>m-1
    //         return;
    //     }
    //     for(int i=0; i<m; i++) { 
    //         if(mat[i][0] == root.val){ //chk cu8rr.root i-->along-m
    //             System.out.println("Root is = "+mat[i][0]);
    //             if(mat[i][2] == 1) { // left child crt
    //                 root.left = new TreeNode(mat[i][1]);
    //                 System.out.println("Root>left is = "+mat[i][1]);
    //                 continue; //mov next i aftr root.left
    //             }else { //right child crt
    //                 root.right = new TreeNode(mat[i][1]);
    //                 System.out.println("Root>right is = "+mat[i][1]);
    //                 continue; //mov next i after root.right
    //             }
    //         }
    //         ind = i; //if a Node has no-childs left & right
    //     }
    //     if(root.left != null) createBt(root.left, mat, m, ind); //chk for ech node fromm Lweft to right side 
    //     if(root.right != null) createBt(root.right, mat, m, ind);
    // }
}