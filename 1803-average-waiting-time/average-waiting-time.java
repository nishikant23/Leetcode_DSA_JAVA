class Solution {
    public double averageWaitingTime(int[][] cust) {
        double timeTaken=0;
        double waitTime=0;

        for(int i=0; i<cust.length; i++) {
            if(timeTaken==0){
                timeTaken = cust[i][0] + cust[i][1];
                waitTime += (timeTaken - cust[i][0]);
                // System.out.println("Time taken = "+timeTaken+" & Wait time = "+waitTime+" Arrival Time = "+cust[i][0]);
            }else{
                if(timeTaken>= cust[i][0]){
                    timeTaken += cust[i][1];
                    waitTime += (timeTaken - cust[i][0]);
                    // System.out.println("Time taken = "+timeTaken+" & Wait time = "+waitTime+" Arrival Time = "+cust[i][0]);
                }else{
                    timeTaken = cust[i][0] + cust[i][1];
                    waitTime += Math.abs(timeTaken - cust[i][0]);
                    // System.out.println("Time taken = "+timeTaken+" & Wait time = "+waitTime+" Arrival Time = "+cust[i][0]);
                }
                
            }
        }
        return waitTime/cust.length;
    }
}