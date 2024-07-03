class Solution {
    public int addDigits(int num) {
        int sum = find(num, 0);

        while(sum >= 10) {
             sum = find(sum, 0);
        }
        return sum;
    }
    public int find(int num, int sum) {
        while(num > 0) {
            int rem = num%10;
            sum += rem;
            num = num/10;
        }
        return sum;
    }
}