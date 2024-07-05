class Solution {
    public int maxOperations(int[] nums, int k) {
        //if(nums.length == 1 && nums[0]==k) return 1;

        Arrays.sort(nums);
        int cnt =0;
        int l=0, r=nums.length-1;
        while(l<r) {
            if(nums[l] + nums[r] == k){
                l++;
                r--;
                cnt++;
            }else if(nums[l] + nums[r] > k) r--;
            else l++;
        }
        return cnt;
    }
}