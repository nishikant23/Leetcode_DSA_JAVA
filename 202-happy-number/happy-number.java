class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while( n != 1 && !set.contains(n)) {
            set.add(n);
            n = getSum(n);
        }
       
       return n==1 ? true : false;

    }

    private int getSum(int n) {
        int sum=0;

       while(n>0) {
        int mod = n%10;
        
         sum += mod*mod;
        
        n = n/10;
       }
       return sum;
    }
}