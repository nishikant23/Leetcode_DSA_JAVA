class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        
         if (hand.length % groupSize != 0) {
            return false; // Length of hand should be divisible by groupSize
        }

        Arrays.sort(hand); // Sort the cards in ascending order

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1); // Increment the count for the current card value
        }

        for (int card : hand) {
            if (countMap.getOrDefault(card, 0) > 0) { // If the current card is not used
                for (int j = 0; j < groupSize; j++) { // Check for consecutive cards
                    int currentCard = card + j;
                    if (!countMap.containsKey(currentCard) || countMap.get(currentCard) == 0) {
                        return false; // Gap found, cannot form consecutive groups
                    }
                    countMap.put(currentCard, countMap.get(currentCard) - 1); // Decrement the count for the used card
                }
            }
        }

        return true; // All cards can be rearranged into consecutive groups
    }
}