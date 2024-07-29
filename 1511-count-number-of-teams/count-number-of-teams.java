class Solution {
    public int numTeams(int[] rating) {
        int cnt=0, n = rating.length;
        for(int i=0; i<n-2; i++){
            for(int j=i+1; j<n-1; j++) {
                for(int k=j+1; k<n; k++){
                    if(rating[i]<rating[j] && rating[j]<rating[k]) cnt++;
                    if(rating[i]>rating[j] && rating[j]>rating[k]) cnt++;
                }
            }
        }
        return cnt;
    }
}