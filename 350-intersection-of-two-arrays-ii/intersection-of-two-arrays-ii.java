class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1<n2){
            for(int n : nums2) map.put(n, map.getOrDefault(n,0)+1); //larger arr values insert
            find( nums1, ls, map);
        }else{
            for(int n : nums1) map.put(n, map.getOrDefault(n,0)+1);
            find(nums2, ls, map);
        }
        int[] res = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            res[i]  = ls.get(i);
        }
        return res;
    }
    public void find(int[] arr, List<Integer> ls, HashMap<Integer, Integer> map) {
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i]) && map.get(arr[i]) > 0) {
                 map.put(arr[i], map.get(arr[i])-1);
                 ls.add(arr[i]);
            }
        }
    }
}