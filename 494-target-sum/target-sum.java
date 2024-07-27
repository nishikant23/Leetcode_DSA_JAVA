class Solution {
    public int[][] t;
    public int findTargetSumWays(int[] nums, int target) {
        int range=0;
        for(int num : nums) range += num;
        if(range-target < 0 || (range - target)%2 != 0) return 0;

        int sum = (range - target)/2;
        t = new int[nums.length+1][sum+1];
        return countSubset(nums, sum, nums.length);
    }
    public int countSubset(int[] arr, int sum, int n){
        for(int i=0; i<n+1; i++) t[i][0] = 1;
        if(arr[0]==0) t[1][0]=2;
        else t[1][0]=1;
        //Iteration
        for(int i=1; i<n+1; i++){
            for(int j=0; j<sum+1; j++){
                if(arr[i-1] <= j)
                   t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
                else
                   t[i][j] = t[i-1][j];
            }
        } 
        //System.out.println("Subset Count="+t[n][sum]);
        return t[n][sum];
    } 
}