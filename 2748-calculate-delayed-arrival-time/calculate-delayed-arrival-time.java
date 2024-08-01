class Solution {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        int t = arrivalTime+delayedTime;
        if(t>=24){
            return (t-24);
        }
        else return t;
    }
}