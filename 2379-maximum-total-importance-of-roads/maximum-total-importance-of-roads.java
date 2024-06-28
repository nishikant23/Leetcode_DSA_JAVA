class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] degrees = new int[n];

        // Step 1: Count the degrees of each city
        for (int[] road : roads) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }

        // Step 2: Create a list of city indices and sort them by their degrees in descending order
        Integer[] cities = new Integer[n];
        for (int i = 0; i < n; i++) {
            cities[i] = i;
        }
        Arrays.sort(cities, (a, b) -> degrees[b] - degrees[a]);

        // Step 3: Assign values from n to 1 based on the sorted list
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[cities[i]] = n - i;
        }

        // Step 4: Calculate the total importance of all roads
        long totalImportance = 0;
        for (int[] road : roads) {
            totalImportance += (long)values[road[0]] + values[road[1]];
        }

        return totalImportance;

    }
}