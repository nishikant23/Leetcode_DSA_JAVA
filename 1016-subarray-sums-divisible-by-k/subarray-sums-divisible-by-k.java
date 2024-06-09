class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum=0,cnt=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1); // Initial case: to handle when the prefix sum itself is  divisible by k
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            int mod = (sum%k + k)%k; // Handle negative mods correctly

                if(map.containsKey(mod)){
                    cnt += map.get(mod); // Add the number of times this mod has occurred befor
                }
                map.put(mod, map.getOrDefault(mod, 0)+1); // Update the freq of this mod
        }
        return cnt;
    } 
}