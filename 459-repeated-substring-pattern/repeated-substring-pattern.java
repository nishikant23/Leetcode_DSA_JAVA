class Solution {
    public boolean repeatedSubstringPattern(String s) {
         // Concatenate the string with itself
        String doubled = s + s;
        
        // Remove the first and last characters
        String modified = doubled.substring(1, doubled.length() - 1);
        
        // Check if the original string is in the modified string
        return modified.contains(s);
        
    }
}