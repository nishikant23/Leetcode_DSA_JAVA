class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();

        for(int i=0; i<nums.length; i++) {

            Long  num = new Long(nums[i]); //convert each arr-elem to long DT

            Long floor = set.floor(num); 
            if(floor != null && num - floor <= t)  // num > floor always
               return true;

            Long ceil = set.ceiling(num);
            if(ceil != null && ceil-num <= t) //num < ceil always
              return true;

            set.add(num);

            if(set.size()>k)  //if Sliding Window size > k
               set.remove(new Long(nums[i-k])); //remove qst eelem of SLW
        }
       return false;
    }
}