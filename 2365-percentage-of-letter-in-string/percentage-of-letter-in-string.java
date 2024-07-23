class Solution {
    public int percentageLetter(String s, char letter) {
        int cnt=0;
        for(char ch : s.toCharArray()){
            if(ch == letter) cnt++;
        }
        
        // float decimal = (float) cnt/s.length();
        // //System.out.println("ANS = "+decimal);
        // int  ans = (int) decimal*100;

        return (cnt*100)/s.length();
    }
}