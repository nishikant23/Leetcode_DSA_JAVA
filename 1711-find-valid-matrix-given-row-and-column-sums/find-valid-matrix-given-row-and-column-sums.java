class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        Set<Integer> rset = new HashSet<>();
        Set<Integer> cset = new HashSet<>();
        int m=rowSum.length, n = colSum.length;
        int[][] matrix = new int[m][n];

        while(rset.size() != m && cset.size() != n) {
            int ri = minInd(rowSum, rset);
            int ci = minInd(colSum, cset);
            if(rowSum[ri]<colSum[ci]){
                matrix[ri][ci] = rowSum[ri];
                colSum[ci] -= rowSum[ri];
                rset.add(ri);
            } else{
                matrix[ri][ci] = colSum[ci];
                rowSum[ri] -= colSum[ci];
                cset.add(ci);
            }
        }    
        return matrix;
    }
    public int minInd(int[] arr, Set<Integer> set){
        int ind=0, min= Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++) {
            if(arr[i]<min && !set.contains(i)){
                min = arr[i];
                ind = i;
            }
        }
        return ind;
    }
}