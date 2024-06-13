class Solution {
    public int minMovesToSeat(int[] seats, int[] stud) {
        Arrays.sort(seats);
        Arrays.sort(stud);
        int sum=0;
        for(int i=0; i<seats.length; i++) {
            sum += Math.abs(seats[i]-stud[i]);
        }
        return sum;
    }
}