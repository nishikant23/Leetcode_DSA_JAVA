class Solution {
    class Pair{
        int par;
        int chld;
        Pair(int par, int chld){
            this.par = par;
            this.chld= chld;
        }
    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Character, String> map = new HashMap<>();
        for(int i=0; i<mapping.length; i++) {
            map.put((char) (i+'0'), Integer.toString(mapping[i]));
        }
        int[] res = new int[nums.length];
        Pair[] pair = new Pair[nums.length];
        for(int p=0; p<nums.length; p++){
            String key = Integer.toString(nums[p]);

            StringBuilder sb = new StringBuilder();
            
            for(char ch : key.toCharArray()) {
                sb.append(map.get(ch));
            }
            pair[p] = new Pair(Integer.parseInt(key), Integer.parseInt(sb.toString()));

        }
        Arrays.sort(pair, (a,b) -> a.chld - b.chld);
        for(int i=0; i<pair.length; i++){
            res[i] = pair[i].par;
        } 
        return res;
    }
}