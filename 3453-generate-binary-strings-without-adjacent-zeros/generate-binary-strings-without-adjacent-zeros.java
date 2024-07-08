class Solution {
    public List<String> validStrings(int n) {
        List<String> ls = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        helper(n, str, 0, ls);
        return ls;
    }
    public void helper(int n, StringBuilder str, int f, List<String> ls) {
        if(n == 0) {
            ls.add(str.toString());
            return;
        }

        if(f==1){
            str.append(1);
            helper(n-1, str , 0, ls);
            str.deleteCharAt(str.length()-1);
        }else{
            str.append(1);
            helper(n-1, str, 0, ls);
            str.deleteCharAt(str.length()-1);
            str.append(0);
            helper(n-1, str, 1, ls);
            str.deleteCharAt(str.length()-1);
        }
    }
}