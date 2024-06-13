class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
       HashMap<String, List<String>> map = new HashMap<>();

       for( String str : strs) {
            char[] ch = str.toCharArray(); //char array
            Arrays.sort(ch); 
            String s = new String(ch);
            if(!map.containsKey(s)) { 
                //if str-not prsnt then onlu put key=str & val=ls
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str); //add to only that same char-key 
       }
       List<List<String>> ans = new ArrayList<>(map.values()); 
       //put all values of map to ans listOfList
        for(List<String> list : ans){ //DEBUGG
            System.out.println("Given List: "+list);
        }
        return ans;
    }
}