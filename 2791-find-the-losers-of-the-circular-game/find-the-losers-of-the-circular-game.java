class Solution {
    public int[] circularGameLosers(int n, int k) {
         boolean[] visited = new boolean[n];
        visited[0] = true;
        
        int i = 0;
        int x = 1;      
        while(!visited[(i + (x*k)) % n]) {
            visited[(i + (x*k)) % n] = true;
            i = (i + (x*k)) % n;
            x++;
        }
        
        int count = 0; 
        for(boolean b : visited) {
            if(!b) {
                count++;
            }
        }
        
        int[]ans = new int[count];
        int index = 0;
        for(int j = 0; j < visited.length; j++) {
            if(!visited[j]) {
                ans[index++] = j+1;
            }
        }
        return ans;
    }
}