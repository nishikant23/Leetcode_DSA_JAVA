class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int c=0;
        for(int i=0; i<words.length-1; i++) {
            for(int j=i+1; j<words.length; j++) {
                if(f(words[i], words[j])) 
                   c++;
            }
        }
        return c;
    }

    public boolean f(String s1, String s2){
        int n=s1.length();
        if(s2.length()<n) return false;

        String prfx = s2.substring(0,n);
        int end = s2.length()-n;
        String sufx = s2.substring(end, s2.length());

        if(s1.equals(prfx) && s1.equals(sufx)) return true;

        return false;
    }
}