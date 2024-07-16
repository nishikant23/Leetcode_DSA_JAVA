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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Find the paths to the start and destination nodes
        List<Character> pathToStart = new ArrayList<>();
        List<Character> pathToDest = new ArrayList<>();
        
        findPath(root, startValue, new ArrayList<>(), pathToStart);
        findPath(root, destValue, new ArrayList<>(), pathToDest);
        
        // Find the divergence point (LCA)
        int i = 0;
        while (i < pathToStart.size() && i < pathToDest.size() && pathToStart.get(i) == pathToDest.get(i)) {
            i++;
        }
        
        // Build the path
        StringBuilder result = new StringBuilder();
        for (int j = i; j < pathToStart.size(); j++) {
            result.append('U');
        }
        for (int j = i; j < pathToDest.size(); j++) {
            result.append(pathToDest.get(j));
        }
        
        return result.toString();
    }
    
    private boolean findPath(TreeNode root, int value, List<Character> currentPath, List<Character> resultPath) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            resultPath.addAll(currentPath);
            return true;
        }
        currentPath.add('L');
        if (findPath(root.left, value, currentPath, resultPath)) {
            return true;
        }
        currentPath.remove(currentPath.size() - 1);
        
        currentPath.add('R');
        if (findPath(root.right, value, currentPath, resultPath)) {
            return true;
        }
        currentPath.remove(currentPath.size() - 1);
        
        return false;
    }
}