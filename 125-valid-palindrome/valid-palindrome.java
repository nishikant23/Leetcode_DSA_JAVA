class Solution {
    public boolean isPalindrome(String s) {
         //1st replace all special charater/numeric with only Char's with loowercase
         String clnStr = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        //^--other than a-z,A-Z,0-9 any char replace those char-with-""(emptyString)

         //now chk 1st n last chars are same or not if not same return false immediately 
         int l=0, r=clnStr.length()-1;
         while(l<r){
            if(clnStr.charAt(l) != clnStr.charAt(r))
               return false;
            
                l++;
                r--;
            
         }
        return true;
    }
}