class Solution {
    public boolean areNumbersAscending(String s) {
         String[] tokens = s.split(" ");
        int previousNumber = -1; // Start with a number smaller than any possible number in the sentence

        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                int currentNumber = Integer.parseInt(token);
                if (currentNumber <= previousNumber) {
                    return false; // The sequence is not strictly increasing
                }
                previousNumber = currentNumber;
            }
        }
        
        return true;
    }
}