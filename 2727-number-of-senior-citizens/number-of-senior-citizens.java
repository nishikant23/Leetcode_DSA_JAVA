class Solution {
    public int countSeniors(String[] details) {
        
        int cnt=0;
        for(String detail : details){
            StringBuilder sb = new StringBuilder();
            for(int i=11; i<13; i++){
                sb.append(detail.charAt(i));
            }
            if(Integer.parseInt(sb.toString()) > 60) cnt++;
        }
        return cnt;
    }
}