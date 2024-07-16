class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        
        // Increment the rows and columns based on the indices
        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        
        // Count the number of odd-valued cells
        int oddCells = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((rows[i] + cols[j]) % 2 == 1) {
                    oddCells++;
                }
            }
        }
        
        return oddCells;
    }
}