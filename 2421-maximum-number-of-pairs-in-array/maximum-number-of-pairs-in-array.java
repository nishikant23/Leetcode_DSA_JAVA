class Solution {
    public int[] numberOfPairs(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        for(int n : nums) ls.add(n);
        int cnt=0;
        for(int i=0; i<ls.size()-1; i++){
            for(int j=i+1; j<ls.size(); j++){
                if(ls.get(i) == ls.get(j)){
                    
                    ls.remove(j);
                    ls.remove(i);
                    cnt++;
                    i--;
                    break;
                }
            }
        }
        // for(int i=0; i<ls.size(); i++){
        //     System.out.println("Ls - elem = "+ls.get(i) );
        // }
        //System.out.println("Pairs="+cnt+" Leftover = "+ls.size());
        return new int[]{cnt, ls.size()};
    }
}