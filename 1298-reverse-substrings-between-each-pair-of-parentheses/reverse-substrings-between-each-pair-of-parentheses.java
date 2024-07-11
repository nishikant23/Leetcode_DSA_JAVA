class Solution {
    public String reverseParentheses(String s) {
        int ansLen = 0;
        for(char c : s.toCharArray()) if(c != '('  && c != ')') ansLen++;
        

        StringBuilder sb = new StringBuilder(s);
        while(true){
            int si=-1, ei=-1;

            for(int i=0; i<sb.length(); i++){
                if(sb.charAt(i)=='(') si = i;
                if(sb.charAt(i) == ')') {
                    ei = i;
                    break;
                }
            }
            // If no parentheses found, break the loop
            if (si == -1 || ei == -1) break;

            reverse(sb, si+1 , ei-1);
            //System.out.println("Sb-len"+sb.length()+" Si="+si+" Ei="+ei);
            // Delete the parentheses
            sb.deleteCharAt(ei);
            sb.deleteCharAt(si);
           
            // for(char c : sb.toString().toCharArray())
            //      System.out.println("Char = "+c);
        }
        return sb.toString();
    }
    public void reverse(StringBuilder sb, int l, int r){
        while(l<r){
        char tmp = sb.charAt(l);
        sb.setCharAt(l, sb.charAt(r));
        sb.setCharAt(r, tmp);
        l++;
        r--;
        }
    }
}