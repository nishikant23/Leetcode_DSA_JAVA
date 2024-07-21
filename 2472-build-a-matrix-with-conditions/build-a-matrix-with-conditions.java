class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
         int[][] matrix = new int[k][k];
        
        // Get the topological order for rows and columns
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);
        
        if (rowOrder.size() != k || colOrder.size() != k) {
            return new int[0][0]; // Impossible to satisfy all conditions
        }
        
        // Create position mappings for rows and columns
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }
        
        // Place each number from 1 to k in the matrix
        for (int i = 1; i <= k; i++) {
            matrix[rowPos[i]][colPos[i]] = i;
        }
        
        return matrix;
    }
    
    private static List<Integer> topologicalSort(int k, int[][] conditions) {
        List<Integer> order = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[k + 1];
        
        // Build graph and in-degree array
        for (int i = 1; i <= k; i++) {
            graph.put(i, new ArrayList<>());
        }
        
        for (int[] condition : conditions) {
            graph.get(condition[0]).add(condition[1]);
            inDegree[condition[1]]++;
        }
        
        // Use a queue to perform topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);
            for (int next : graph.get(current)) {
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        
        return order;
    }
}