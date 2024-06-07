class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        } 
        int cnt=0;
        for(char ch : ransomNote.toCharArray()) {
            //char ch = ransomNote.charAt(i);
            if(map.containsKey(ch)){
                cnt++;
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) map.remove(ch);
            }
        }
        return cnt==ransomNote.length() ? true : false;
    }
}