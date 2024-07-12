class Solution {
    public int maximumGain(String s, int x, int y) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        int f=0, ans=0;;
        if(x>y) f=1;
        else f=0;
        for(char ch : s.toCharArray()){
            if(!s1.isEmpty()) {
                if(f==1){
                    if(s1.peek() == 'a' && ch == 'b'){
                        ans += x;
                        s1.pop();
                    } 
                    else s1.push(ch);
                }else{
                    if(s1.peek()=='b' && ch == 'a'){
                        ans += y;
                        s1.pop();
                    }
                    else s1.push(ch);
                }
            }
            else{
                s1.push(ch);
            }
        }

        for(char ch : s1){
            if(!s2.isEmpty()) {
                if(f==0){
                    if(s2.peek() == 'a' && ch == 'b'){
                        ans += x;
                        s2.pop();
                    } 
                    else s2.push(ch);
                }else{
                    if(s2.peek()=='b' && ch == 'a'){
                        ans += y;
                        s2.pop();
                    }
                    else s2.push(ch);
                }
            }
            else{
                s2.push(ch);
            }
        }
        return ans;
    }
}