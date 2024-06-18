class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int m = worker.length;

        int[][] jobs = new int[n][2];
        for(int i=0; i<n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]); // sort wrt difficulty
        Arrays.sort(worker); //Sort worker wrt their ability

        int maxP = 0;
        int validP = 0;
        int j=0; //index to track worker's ability array

        for(int i=0; i<m; i++) { //till Worker-arr len
            while(j<n && worker[i] >= jobs[j][0]) {
//j<n if worker-arr < jobs-arr & w[i] = stick at i=0 till maxP not fnd
//&& traverse each jobs[j-not beyond wrkr-arr][0] difficuly 
                  validP = Math.max(validP, jobs[j][1]);
                  j++;            
            }
            maxP += validP;
        }
        return maxP;
    }
}