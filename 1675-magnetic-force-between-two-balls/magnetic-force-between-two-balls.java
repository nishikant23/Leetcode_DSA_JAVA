class Solution {
    public int maxDistance(int[] arr, int m) {
        Arrays.sort(arr);
        int l = 1, r = arr[arr.length-1] - arr[0];
        int res = 0;
        while(l<=r) {
           int mid = l+(r-l)/2;
            if(find(arr, m, mid)){
                res = mid;
                l=mid+1;

            }else {
                r=mid-1;
            }
        }
        return res;
    }
    public boolean find(int[] arr, int m, int minDist) {
        int cnt=1;
        int lastBallPlaced = arr[0];

        for(int i=1; i<arr.length; i++) {
            if(arr[i] - lastBallPlaced >= minDist){
                cnt++;
                lastBallPlaced = arr[i];
                if(cnt == m){
                    return true;
                }
            }
        }
        return false;
    }
}