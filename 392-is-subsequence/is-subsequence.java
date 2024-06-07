class Solution {
    public boolean isSubsequence(String s, String t) {
       int i=0,j=0; //i pts s-str & j pts t-str

       while(i<s.length() && j<t.length()) {
        if(s.charAt(i) == t.charAt(j)){ //match found move bth ptrs
            i++;  
            j++;
        }else j++;
       }

       //if orderwisee subsequence then only io==s.len
       //else, either subseq not found OR subseq present unorderwise
       return i==s.length() ? true : false;
    }
}