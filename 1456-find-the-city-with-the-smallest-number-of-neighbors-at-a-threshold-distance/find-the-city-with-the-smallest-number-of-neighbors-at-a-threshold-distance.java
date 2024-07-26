class Solution {
    static class Pair {
        int city, weight;
        Pair(int city, int weight) {
            this.city = city;
            this.weight = weight;
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
         // Step 1: Create the adjacency list
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Pair(edge[1], edge[2]));
            graph.get(edge[1]).add(new Pair(edge[0], edge[2]));
        }

        // Step 3: Find the city with the smallest number of reachable cities within the threshold
        int minReachableCount = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int reachableCount = dijkstra(i, graph, n, distanceThreshold);
            if (reachableCount < minReachableCount || (reachableCount == minReachableCount && i > resultCity)) {
                minReachableCount = reachableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }
     // Step 2: Function to perform Dijkstra's algorithm
    public static int dijkstra(int start, List<List<Pair>> graph, int n, int distanceThreshold) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;
        pq.offer(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.city;
            int currentDistance = current.weight;

            if (currentDistance > distances[u]) {
                continue;
            }

            for (Pair neighbor : graph.get(u)) {
                int v = neighbor.city;
                int weight = neighbor.weight;
                int distance = currentDistance + weight;
                if (distance < distances[v]) {
                    distances[v] = distance;
                    pq.offer(new Pair(v, distance));
                }
            }
        }

        int reachableCount = 0;
        for (int distance : distances) {
            if (distance <= distanceThreshold) {
                reachableCount++;
            }
        }
        return reachableCount;
    }

}