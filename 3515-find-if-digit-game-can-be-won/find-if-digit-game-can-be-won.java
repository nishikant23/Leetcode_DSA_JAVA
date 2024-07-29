class Solution {
    public boolean canAliceWin(int[] nums) {
        int sDgt=0, dDgt=0;
        for(int num : nums){
            if(num<10) sDgt += num;
            if(num>=10) dDgt += num;
        }
        System.out.println("Single Digit = "+sDgt);
        System.out.println("Double Digit = "+dDgt);
        if(sDgt == dDgt) return false;
        return true;
    }
}