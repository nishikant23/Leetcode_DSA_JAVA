class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++){
                int x = matrix[i][j];

                boolean isRow = true, isCol = true;
                for(int col=0; col<matrix[0].length; col++) {
                    if(x>matrix[i][col]) {
                        isRow = false;
                        break;
                    } 
                }
                if(isRow) {
                    for(int row=0; row<matrix.length; row++){
                        if(x<matrix[row][j]) {
                            isCol = false;
                            break;
                        }
                    }   
                }
                
                
                if(isRow&& isCol) ls.add(x);
            }
        }
        return ls;
    }
}