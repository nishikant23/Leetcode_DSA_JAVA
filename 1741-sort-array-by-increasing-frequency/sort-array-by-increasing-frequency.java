class Solution {
    class Pair{
        int num;
        int freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Pair[] pair = new Pair[nums.length];
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        for(int i=0; i<nums.length; i++){
            pair[i] = new Pair(nums[i], map.get(nums[i]));
        }
        Arrays.sort(pair, (a,b) -> { //Comparator Chaining
            if(a.freq != b.freq)
               return a.freq - b.freq;
            else 
               return b.num - a.num;
        });

        int[] sortedNums = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            sortedNums[i] = pair[i].num;
        }
        return sortedNums;
    }
}