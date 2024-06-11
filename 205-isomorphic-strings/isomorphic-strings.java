class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);
            if(!mapS.containsKey(chs)){
                mapS.put(chs, cht);
            }else {
                if(mapS.get(chs) != cht) return false;
                else continue;
            }

            if(!mapT.containsKey(cht)){
                mapT.put(cht, chs);
            }else {
                if(mapT.get(cht) != chs) return false;
                else continue;
            }
        }
        return true;
    }
}