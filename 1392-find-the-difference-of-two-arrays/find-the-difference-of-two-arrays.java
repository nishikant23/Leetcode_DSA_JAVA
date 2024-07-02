class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        ans.add(find(nums1, nums2));
        ans.add(find(nums2, nums1));

        return ans;
    }
    public List<Integer> find(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ls = new ArrayList<>();

        for(int n : nums2) map.put(n, map.getOrDefault(n, 0)+1);

        for(int i=0; i<nums1.length; i++) {
            if(map.containsKey(nums1[i])) continue;
            else{
                if(!ls.contains(nums1[i]))
                    ls.add(nums1[i]);
            }
        }
        return ls;
    }
}