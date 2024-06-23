class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        boolean flag = true;

        for(char ch: s.toCharArray()){
            flag=false;
            if(ch==')' || ch==']' || ch=='}'){

               if(st.isEmpty()) return false;

               char c = st.pop();
               if((c=='(' && ch==')') || (c=='[' && ch==']') || (c=='{' && ch=='}') )
               flag = true;
               else return false; 
            }else
            st.push(ch); //else, bcos to only add openBrks.
        }

        if(!st.isEmpty()) {
          return false;  
        }
        return flag;
    }
}