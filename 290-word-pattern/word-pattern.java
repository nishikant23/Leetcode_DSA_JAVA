class Solution {
    public boolean wordPattern(String s, String temp) {
        HashMap<Character, String> mapS = new HashMap<>();
        HashMap<String, Character> mapT = new HashMap<>();
        String[] t = temp.split(" ");
        for(String ch : t) System.out.println("Str: "+ch);

        if(s.length() != t.length) return false;

        for(int i=0; i<t.length; i++){
            char chs = s.charAt(i);
            String cht = t[i];
            if(!mapS.containsKey(chs)){ 
                mapS.put(chs, cht);
            }else {
                if(!mapS.get(chs).equals(cht)) return false;
                //else continue;
            }
            if(!mapT.containsKey(cht)){ 
                mapT.put(cht, chs);
            }else {
                if(!mapT.get(cht).equals(chs)) return false;
                //else continue;
            }
        }
        return true;
    }
}