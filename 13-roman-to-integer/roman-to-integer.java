class Solution {
    public int romanToInt(String s) {
         HashMap<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int total = 0;
        int prevValue = 0;
        
        // Iterate through the string from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int curValue = romanMap.get(s.charAt(i));
            
            // If the current value is smaller than the previous value, subtract it
            if (curValue < prevValue) {
                total -= curValue;
            } else {
                total += curValue;
            }
            
            prevValue = curValue;
        }
        
        return total;
        
    }
}