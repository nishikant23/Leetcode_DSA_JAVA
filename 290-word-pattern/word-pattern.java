class Solution {
    public boolean wordPattern(String s, String temp) {
        HashMap<Character, String> mapS = new HashMap<>();
        String[] t = temp.split(" ");
        if(s.length() != t.length) return false;
        //for(String ch : t) System.out.println("Str: "+ch);

        for(int i=0; i<s.length(); i++){
            char chs = s.charAt(i);
            String cht = t[i];
            if(mapS.containsKey(chs)){ 
                if(!mapS.get(chs).equals(cht)) return false;
            }else {
                if(mapS.containsValue(cht)) return false;

                mapS.put(chs, cht);
            }
        }
        return true;
    }
}