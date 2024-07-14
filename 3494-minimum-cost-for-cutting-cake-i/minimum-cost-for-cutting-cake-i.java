class Solution {
    public int minimumCost(int m, int n, int[] hcut, int[] vcut) {
        Arrays.sort(hcut);
        reverse(hcut, 0, hcut.length-1);
        Arrays.sort(vcut);
        reverse(vcut, 0, vcut.length-1);

        long tc=0;
        long hblocks=1, vblocks=1;
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

        while(i<hcut.length){
            tc += hcut[i]*vblocks;
            i++;
        }

        while(j<vcut.length){
            tc += vcut[j]*hblocks;
            j++;
        }
        

        return (int) tc;
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