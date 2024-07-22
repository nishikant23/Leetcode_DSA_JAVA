class Solution {
    class Pair{
        String name;
        int height;
        Pair(String name, int height){
            this.name = name;
            this.height = height;
        }
    }
    public String[] sortPeople(String[] names, int[] heights) {
        Pair[] ls = new Pair[names.length];
        for(int i=0; i<names.length; i++){
            ls[i] = new Pair(names[i], heights[i]);
        }

        Arrays.sort(ls, (a,b) -> b.height - a.height);
        
        String[] sortedNames = new String[names.length];
        for(int i=0; i<names.length; i++){
            sortedNames[i] = ls[i].name;
        }
        return sortedNames;
    }
}