class Solution {
    public int countEven(int num) {
        int cnt=0;
        for(int i=1; i<=num; i++) {
            if(i <= 9 ) {
                if(i%2 == 0){
                cnt++;
                //System.out.println("Single digit even = "+i);
                } 
            }
            else {
                int number=0;
                String str = Integer.toString(i);
                
                for(char ch : str.toCharArray()){
                    int digit = ch - '0';
                    number += digit;
                }
                if(number%2 == 0){
                        cnt++;
                        //System.out.println("Double digit even = "+str);
                } 
            }    
        }
        return cnt;
    }
}