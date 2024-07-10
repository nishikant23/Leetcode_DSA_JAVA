class Solution {
    public String removeStars(String s) {
        //Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '*') {
                if(sb != null)
                   sb.deleteCharAt(sb.length()-1);
            }
            else sb.append(c);
        }
        return sb.toString();
        // for(char c : s.toCharArray()){
        //     if(c == '*'){
        //         if(!st.isEmpty()) 
        //             st.pop();
        //     }else {
        //         st.push(c);
        //     }
        // }
        // String ans = "";
        // if(st.isEmpty()) return ans;

        // while(!st.isEmpty()) {
        //     ans = ans.concat(String.valueOf(st.pop()));
        // }
        // return ans;
    }
}