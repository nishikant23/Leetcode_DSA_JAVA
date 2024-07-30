class Solution {
    public int minimumDeletions(String s) {
        int cnt=0;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for(int i=1; i<s.length(); i++){
            if(!st.isEmpty() && s.charAt(i)=='a' && st.peek()=='b' ){
                st.pop();
                cnt++;
                continue;
            }
            st.push(s.charAt(i));
        }
        return cnt;
    }
}