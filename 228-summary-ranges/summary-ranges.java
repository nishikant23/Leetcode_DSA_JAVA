class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ls = new ArrayList<>();
        int i=0;
        while(i<nums.length) {
            int start = nums[i];
            while(i<nums.length-1 && (nums[i] + 1 == nums[i+1])){
                i++; //till the range 
            }
            int end = nums[i];
            if(start == end) ls.add(String.valueOf(start));
            else ls.add(String.valueOf(start) + "->" + String.valueOf(end));
            i++; //+1 index of out of range 
        }
       return ls;
    }
}