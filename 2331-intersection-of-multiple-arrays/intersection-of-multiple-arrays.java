class Solution {
    public List<Integer> intersection(int[][] nums) {
        int n=nums.length;
        List<Integer> ls = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<nums[i].length; j++){
                map.put(nums[i][j], map.getOrDefault(nums[i][j],0)+1);
                if(map.get(nums[i][j]) == n) ls.add(nums[i][j]);
                //System.out.println("Element: "+nums[i][j]);
            }
        }
        Collections.sort(ls);
        return ls;
    }
}