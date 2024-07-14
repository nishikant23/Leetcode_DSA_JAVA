class Solution {
    public int findPoisonedDuration(int[] ts, int dur) {
       if(ts.length == 0) return 0;

       int poisonDur = 0;

       for(int i=0; i<ts.length-1; i++) {
            poisonDur += Math.min(dur, ts[i+1] - ts[i]); //cos, if next-arr-elem lies inside duration, it
                                                        // resets its value from that new elem
       }
       poisonDur += dur; // Add the duration of the last attack

       return poisonDur;
    }
}