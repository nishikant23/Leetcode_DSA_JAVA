class Solution {
    public List<List<String>> ans;
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        for(int i=0; i<n; i++){
            char[] str = new char[n];
            for(int j=0; j<n; j++){
                str[j] = '.';
            }
            board.add(new String(str));
        }
        solve(board, 0, n);
        return ans;
    }
    public boolean isSafe(List<String> board, int row, int col, int n){
         // Check this column on the upper side
        for (int i = 0; i < row; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        // Check the upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        // Check the upper right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }
    public void solve(List<String> board, int row, int n){
        if(row == n){
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col=0; col<board.size(); col++){
            if(isSafe(board, row, col, n)){
                 // Place the queen and move to the next row
                board.set(row, board.get(row).substring(0, col) + 'Q' + board.get(row).substring(col + 1));
                solve(board, row + 1, n);
                // Backtrack and remove the queen
                board.set(row, board.get(row).substring(0, col) + '.' + board.get(row).substring(col + 1));
            }
        }
    }
}