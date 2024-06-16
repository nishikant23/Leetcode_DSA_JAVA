class Solution {
    public int minPatches(int[] nums, int n) {
        int i=0;
        long miss=1;
        int patch=0;

        while(miss<=n){
            if(i<nums.length && nums[i]<=miss){
                miss += nums[i];
                i++;
            }else {
                miss += miss;
                patch++;
            }
        }
        return patch;
    }
}