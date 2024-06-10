class Solution {
    public int heightChecker(int[] ht) {
        int[] exp = Arrays.copyOf(ht,ht.length);
        
        Arrays.sort(exp);
        int cnt=0;
        for(int i=0; i<ht.length; i++){
            if(ht[i] != exp[i]) cnt++;
        }
        return cnt;
    }
}