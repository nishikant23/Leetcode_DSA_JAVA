class Solution {
    public int passThePillow(int n, int time) {
      int effTime = time % (2*(n-1));
      if(effTime<n) 
         return  effTime+1;
      else
         return ((2*n) -effTime -1);
    }
}
//Forward Pass: The pillow passes from person 1 to person \U0001d45b = n-1
//Backward Pass: The pillow passes from person \U0001d45b back to person 1 = n-1
//A full cycle consists of both a forward pass and a backward pass. Hence, the length of a full cycle is 2*(n-1)
//The effective time is the remainder when time is divided by the length of a full cycle, 2×(\U0001d45b−1)
//If effectiveTime is less than \U0001d45b, the pillow is in the forward pass phase.
//If effectiveTime is greater than or equal to n, the pillow is in the backward pass phase.