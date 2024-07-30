class Solution {
    public boolean checkString(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();
        for(int i=0; i<n; i++){
            if(!st.isEmpty() && st.peek()=='b' && s.charAt(i) == 'a') {
                return false;
            }else {
                st.push(s.charAt(i));
            }
        }
        return true;
    }
}