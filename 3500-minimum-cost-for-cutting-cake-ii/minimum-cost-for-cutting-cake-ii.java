class Solution {
    public long minimumCost(int m, int n, int[] hcut, int[] vcut) {
        Arrays.sort(hcut); // Sort horizontal cuts
        reverse(hcut, 0, hcut.length-1); //reverse sorted arry to descending order
        Arrays.sort(vcut); // Sort vertical cuts
        reverse(vcut, 0, vcut.length-1); //reverse sorted arry to descending order

        long tc=0;
        long hblocks=1, vblocks=1; // Initial blocks
        int i=0, j=0;
        //while(i<m-1 && j<n-1){
        while(i<hcut.length && j<vcut.length){
            if(hcut[i] > vcut[j]){
                tc += hcut[i]*(vblocks);
                hblocks++;
                i++;
            }else {
                tc += vcut[j]*(hblocks);
                vblocks++;
                j++;
            }
        }

         // Add remaining horizontal cuts, if still cost not taken in abv loop
        while(i<hcut.length){
            tc += hcut[i]*vblocks;
            i++;
        }
         // Add remaining vertical cuts,  if still cost not taken in abv loop
        while(j<vcut.length){
            tc += vcut[j]*hblocks;
            j++;
        }
        return  tc;
    }
    public void reverse(int[] arr, int l, int r) {
        while(l<r){
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++;
            r--;
        }
    }
}
