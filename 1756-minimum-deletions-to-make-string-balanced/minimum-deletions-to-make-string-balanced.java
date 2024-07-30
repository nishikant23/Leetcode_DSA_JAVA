class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] cntA = new int[n];
        int[] cntB = new int[n];
        int aCnt=0, bCnt=0;
        for(int i=0; i<n; i++){
            cntB[i] = bCnt;
            if(s.charAt(i)=='b') bCnt++; 
        }

        for(int i=n-1; i>=0; i--){
            cntA[i] = aCnt;
            if(s.charAt(i)=='a') aCnt++;
        }
        int minDel=n;
        for(int i=0; i<n; i++){
            minDel = Math.min(minDel, cntA[i] + cntB[i]);
        }
        return minDel;
    }
}