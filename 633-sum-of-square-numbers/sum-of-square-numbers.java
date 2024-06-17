class Solution {
    public boolean judgeSquareSum(int n) {
        if(n==1) return true;
        long l=0, r=(long) Math.sqrt(n);
        while(l<=r) {
            long sum = (l*l + r*r);
           if(sum == n){
            //System.out.println("l= "+l+" & r= "+r);
            return true;
           }
           else if(sum > n) {
            //System.out.println("Sq- Sum > n; l= "+l+" & r= "+r);
            r--;
           }
           else{
             //System.out.println("Sq-Sum < n; l= "+l+" & r= "+r);
            l++;
           } 
        }
        return false;
    }
}