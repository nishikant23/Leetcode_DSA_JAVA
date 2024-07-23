class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch, int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        Pair[] pair = new Pair[s.length()];
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(int i=0; i<s.length(); i++){
            pair[i] = new Pair(s.charAt(i), map.get(s.charAt(i)));
        }
        Arrays.sort(pair, (a,b) -> {
            if(a.freq != b.freq)
               return b.freq - a.freq;
            else 
               return a.ch - b.ch;
            }
        );

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<pair.length; i++){
            sb.append(pair[i].ch);
        }
        return sb.toString();
    }
}