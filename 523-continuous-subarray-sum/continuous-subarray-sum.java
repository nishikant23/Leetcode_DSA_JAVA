class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
    int[] prefixSum = new int[n + 1];
    for (int i = 0; i < n; i++) {
        prefixSum[i + 1] = prefixSum[i] + nums[i];
    }
    
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    for (int i = 0; i < n; i++) {
        int remainder = prefixSum[i + 1] % k;
        if (map.containsKey(remainder)) {
            if (i - map.get(remainder) > 1) {
                return true;
            }
        } else {
            map.put(remainder, i);
        }
    }
    
    return false;
    }
    
}