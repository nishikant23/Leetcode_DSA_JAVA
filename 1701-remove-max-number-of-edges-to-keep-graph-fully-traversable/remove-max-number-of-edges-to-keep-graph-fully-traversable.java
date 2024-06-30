class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
     // Create Union-Find structures for Alice and Bob
        UnionFind aliceUF = new UnionFind(n);
        UnionFind bobUF = new UnionFind(n);
        
        int edgesUsed = 0;
        
        // First, add type 3 edges (usable by both Alice and Bob)
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                if (aliceUF.union(edge[1] - 1, edge[2] - 1) | bobUF.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            }
        }
        
        // Add type 1 edges (usable by Alice only)
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (aliceUF.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            }
        }
        
        // Add type 2 edges (usable by Bob only)
        for (int[] edge : edges) {
            if (edge[0] == 2) {
                if (bobUF.union(edge[1] - 1, edge[2] - 1)) {
                    edgesUsed++;
                }
            }
        }
        
        // Check if both Alice and Bob can fully traverse the graph
        if (aliceUF.isConnected() && bobUF.isConnected()) {
            return edges.length - edgesUsed;
        }
        
        return -1;
    }

    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int u) {
            if (parent[u] != u) {
                parent[u] = find(parent[u]);
            }
            return parent[u];
        }
        
        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            
            if (rootU != rootV) {
                if (rank[rootU] > rank[rootV]) {
                    parent[rootV] = rootU;
                } else if (rank[rootU] < rank[rootV]) {
                    parent[rootU] = rootV;
                } else {
                    parent[rootV] = rootU;
                    rank[rootU]++;
                }
                count--;
                return true;
            }
            return false;
        }
        
        public boolean isConnected() {
            return count == 1;
        }
    }
}