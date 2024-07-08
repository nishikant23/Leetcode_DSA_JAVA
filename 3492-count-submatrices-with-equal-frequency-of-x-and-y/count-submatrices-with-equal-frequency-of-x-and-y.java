class Solution {
    public int numberOfSubmatrices(char[][] grid) {
         int r = grid.length, c = grid[0].length;
         int[][] Xcnt = cntFreq(grid, 'X'); //No. of x-freq gird
         int[][] Ycnt = cntFreq(grid, 'Y'); //No. of Y freq grid
         int ans=0;
         
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++) {
                if(Xcnt[i][j] == Ycnt[i][j] && Xcnt[i][j]>0) ans++;
            }
        }
        return ans;

    }
    public int[][] cntFreq(char[][] grid, char ch){
        int r = grid.length, c = grid[0].length;

        int[][] prefix = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++) {
                prefix[i][j]  = (grid[i][j] == ch) ? 1 : 0;
                if(i>0) prefix[i][j] += prefix[i-1][j];
                if(j>0) prefix[i][j] += prefix[i][j-1];
                if(i>0 && j>0) prefix[i][j] -= prefix[i-1][j-1]; //diagonally-just-prev block to curr-block[i][j]
            }
        }
        return prefix;
    }
}