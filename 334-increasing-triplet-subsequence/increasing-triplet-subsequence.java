class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3) return false;

        int lowest = Integer.MAX_VALUE;
        int mid = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
             if(nums[i] <= lowest)  lowest = nums[i];
             else if(nums[i] <= mid) {
                mid = nums[i];
                //if(lowest == mid || lowest > mid) mid = Integer.MAX_VALUE;
             }
             else return true;
        }
        return false;
    }
}