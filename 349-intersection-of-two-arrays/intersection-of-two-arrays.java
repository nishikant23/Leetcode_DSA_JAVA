class Solution {
    int[] res;
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1<n2){
            for(int n : nums2) map.put(n, map.getOrDefault(n,0)+1); //larger arr values insert
            res = find(nums1, map);
        }else{
            for(int n : nums1) map.put(n, map.getOrDefault(n,0)+1);
            res = find(nums2, map);
        }
        
        return res;
    }
    public int[] find(int[] arr, HashMap<Integer, Integer> map) {
         HashSet<Integer> dup = new HashSet<>();
        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i]) && !dup.contains(arr[i])) {
                 //map.put(arr[i], map.get(arr[i])-1);
                 dup.add(arr[i]);
            }
        }
        List<Integer> ls = new ArrayList<>(dup);

        res = new int[ls.size()];
        for(int i=0; i<ls.size(); i++){
            res[i]  = ls.get(i);
        }
        return res;
    }
}