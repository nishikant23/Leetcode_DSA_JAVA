class Solution {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
      int n = profits.length;
      int[][] proj = new int[n][2];

      for(int i=0; i<n; i++) {
        proj[i][0] = capital[i];
        proj[i][1] = profits[i];
      }

      Arrays.sort(proj, (a,b) -> a[0] - b[0]); //sort w.r.t capital values

      PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
      int projInd = 0;
      
      for(int i=0; i<k; i++) {
        
        while(projInd < n && proj[projInd][0] <= w) {
            pq.add(proj[projInd][1]);
            projInd++;
        }

        if(pq.isEmpty()) break; //no such proj exists acc. to our cap

        w  += pq.poll();
      }
      return w;
    }
}