class Solution {
    class Pair{
        int num; 
        int freq;
        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums){
            if(num%2 == 0)
               map.put(num, map.getOrDefault(num, 0)+1);
        }

        if (map.isEmpty()) {
            return -1;
        }

        Pair[] pair = new Pair[map.size()];
        int i=0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pair[i] = new Pair(entry.getKey(), entry. getValue());
            i++;
        }
        Arrays.sort(pair, (a,b) -> {
            if(a.freq != b.freq)
               return b.freq - a.freq;
            else 
               return a.num - b.num;
        });

        return pair[0].num;
    }
}