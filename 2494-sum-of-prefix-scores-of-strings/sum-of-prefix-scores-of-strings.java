public class Node{ //Trie
    Node[] link = new Node[26];
    
    int prefixCount=0;

    boolean containsKey(char ch){
        return link[ch -'a'] != null;
    }
    void crtNode(char ch,  Node node) {
        link[ch -'a'] = node;
    }

    Node moveNode(char ch){
        return link[ch - 'a'];
    }
    void increasePrefix(){
        prefixCount++;
    }
    int getPrefix(){
        return prefixCount;
    }

}


class Solution {
    public Node root;

    Solution() {
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(char ch : word.toCharArray()){
            if(!node.containsKey(ch)){
                node.crtNode(ch, new Node());
            }
            node = node.moveNode(ch);
            node.increasePrefix();
        }
    }
    public int[] sumPrefixScores(String[] words) {
        for(String str : words){
            insert(str);
        }
       
        int[] answer = new int[words.length]; //to store each str prefix

        for(int i=0; i<words.length; i++){
            answer[i] = calculatePrefix(words[i]);
        }
        
        return answer;
    }
    public int calculatePrefix(String str){
        Node node = root;
        int score = 0;
        for(char ch : str.toCharArray()){
            if(!node.containsKey(ch)){
                return score;
            }
            node = node.moveNode(ch);
            score += node.getPrefix();
        }
        return score;
    }
}