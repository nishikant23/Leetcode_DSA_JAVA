class Solution {

    public int findNumbers(int[] nums) {
        int cntEven = 0;

        for(int num : nums) {
            String str = Integer.toString(num);
            if(str.length()%2 == 0) cntEven++;
        }
        return cntEven;
    }
}