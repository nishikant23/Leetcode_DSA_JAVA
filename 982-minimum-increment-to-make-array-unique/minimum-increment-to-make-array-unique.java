class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums); //makes duplicates elem adjacent to e/o
        int cnt=0;

        for(int i=1; i<nums.length; i++) { 
            if(nums[i] <= nums[i-1]) { //curr <= prev means, curr-is-not-unique
                int incr = nums[i-1] - nums[i] +1; //+1 increment Qs condition
                //n[i-1] -n[i]==0 ? adj-duplicate : curr<prev as per sorting IT-MUST-prev<curr 
                nums[i]  += incr;
                cnt += incr;
            }
        }
        return cnt;
    }
}