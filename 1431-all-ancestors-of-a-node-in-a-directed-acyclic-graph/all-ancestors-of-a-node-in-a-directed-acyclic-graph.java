class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Create adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        // Topological Sort using Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            topoOrder.add(node);
            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Initialize ancestor sets for each node
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }

        // Build ancestors list using topological order
        for (int node : topoOrder) {
            for (int neighbor : graph.get(node)) {
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));
            }
        }

        // Convert sets to sorted lists
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> ancestorSet : ancestors) {
            List<Integer> ancestorList = new ArrayList<>(ancestorSet);
            Collections.sort(ancestorList);
            result.add(ancestorList);
        }

        return result;
    }


}