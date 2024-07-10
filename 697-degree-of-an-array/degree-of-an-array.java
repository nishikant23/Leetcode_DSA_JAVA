class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> fst = new HashMap<>();
        HashMap<Integer, Integer> snd = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int n = nums[i];
            map.put(n , map.getOrDefault(n, 0)+1);
            if(!fst.containsKey(n)) fst.put(n, i);
            snd.put(n, i);
        } 

        int maxDegree=0;
        for(int freq : map.values()) {
           maxDegree = Math.max(maxDegree, freq);
        }

        

        int minLen = Integer.MAX_VALUE;
        for(int n : map.keySet()){
            if(map.get(n) == maxDegree){
                int si = fst.get(n);
                int ei = snd.get(n);minLen = Math.min(minLen, ei-si+1);
            }
        }
        return minLen;
    }
}