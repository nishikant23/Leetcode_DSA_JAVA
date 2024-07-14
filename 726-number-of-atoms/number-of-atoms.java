class Solution {
    
    public String countOfAtoms(String s) {
        int n=s.length();
        HashMap<String, Integer> map = new HashMap<>();
        Stack<HashMap<String, Integer>> st = new Stack<>();
        int i=0;
        while(i<n) {
            char c = s.charAt(i);

            if(Character.isLetter(c)) {
                int j=i+1;
                while(j<n && Character.isLowerCase(s.charAt(j))) j++;

                String elem = s.substring(i,j);
                i=j;
                int count=0;
                while(i<n && Character.isDigit(s.charAt(i))){
                    count = count*10 + (s.charAt(i) - '0');
                    i++;
                }
                count = (count==0) ? 1 : count; 
                map.put(elem, map.getOrDefault(elem, 0)+count);
            }
            else if(c == '('){
                st.push(new HashMap<>(map)); //new Map insert into Stack
                map.clear(); //empty that inserted-Map then
                i++;
            }
            else if(c == ')') {
                int j=i+1;
                int count = 0;
                while(j<n && Character.isDigit(s.charAt(j))){
                    count  = count*10 + (s.charAt(j) - '0');
                    j++;
                }
                count = (count==0) ? 1 : count; 
                i=j;

                HashMap<String, Integer> tempMap = new HashMap<>();
                for(Map.Entry<String, Integer> entry : map.entrySet()){
                    tempMap.put(entry.getKey(), entry.getValue()*count);
                }
                map = st.pop(); //w/o clring earlier map-still new map only has St.pop( Map-key-values)

                for(Map.Entry<String, Integer> entry : tempMap.entrySet()){
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0)+entry.getValue());
                }
            }else {
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        List<String> ls = new ArrayList<>(map.keySet());
        Collections.sort(ls);
        for(String elem : ls) {
            sb.append(elem);
            if(map.get(elem)>1){
                sb.append(map.get(elem));
            }
        } 
        return sb.toString();
    }
}