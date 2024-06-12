class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            }else {
                if(Math.abs(i-map.get(nums[i])) <= k) return true;
                else map.put(nums[i], i);
            }
        }
        // for(int i=0; i<nums.length-1; i++){
            
        //         if(nums[i] == nums[j] && Math.abs(i-j)<=k) return true;
        // }
        return false;
    }
}