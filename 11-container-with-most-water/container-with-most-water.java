class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1,wid=0, ht=Integer.MAX_VALUE,area=0;
        while(l<r){

            wid = r-l;
            ht = Math.min(height[l], height[r]);
            area = Math.max(area, wid*ht);
            if(height[l]<height[r]) l++;
            else r--;

        }
        return area;
    }
}