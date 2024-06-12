class Solution {
    public void sortColors(int[] nums) {
        int l=0, m=0, r=nums.length-1;
        while(m<=r){
           if(nums[m] == 0) {
            swap(nums, l, m);
            m++;
            l++;
           }
           else if(nums[m] == 1) m++;
           else if(nums[m] == 2){
            swap(nums, m, r);
            r--;
           }
        }
    }
    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}