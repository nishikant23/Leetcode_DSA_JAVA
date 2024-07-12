class Solution {
    public int wordCount(String[] sw, String[] tw) {
        
        Set<Integer> set = new HashSet<>();
        for(String word : sw) set.add(bitMask(word));

        int count=0;

        for(String target : tw) {
            int targetMask = bitMask(target);
            for(char ch : target.toCharArray()){
                int newTarget = targetMask & ~(1<<(ch - 'a'));
                if(set.contains(newTarget)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
    public int bitMask(String word) {
            int mask = 0;
            for(char ch : word.toCharArray()) {
                mask |= (1<<(ch - 'a'));
            }
            return mask;
    }
}