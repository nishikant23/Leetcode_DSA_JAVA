class Node {
    Node arr[] = new Node[26];
    boolean flag = false;

    public Node() {

    }
    boolean containsKey(char ch){
        return arr[ch - 'a'] != null;
    }
    void putCharToNode(char ch, Node node) {
         arr[ch - 'a'] = node; //if char not found in arr[26]-root/node create one at that posn
    }
    Node moveToNewCrtedNode(char ch) {
        return arr[ch -'a']; //nothing but holds the Newly crted refs node
    }
    void setEnd() {
        flag = true;
    }
    boolean isEnd() {
        return flag; //made inserted word end-empty-node flag=true, if not exist-word then it
                     // won't have any end-empty-node hence its flag will not beee
    }
}

class Trie extends Node {
    Node root;
    public Trie() {
        root  = new Node();
    }

    
    public void insert(String word) {
       Node node = root;
       for(int i=0; i<word.length(); i++) {
        char ch = word.charAt(i);
           if(!node.containsKey(ch)){
              node.putCharToNode(ch, new Node()); //on curr-node create NewNode at ch-posn
           }
           node = node.moveToNewCrtedNode(ch);
       }
       node.setEnd(); //after word insert set its empty-last-node flag=true
    }
    
    public boolean search(String word) {
       Node node = root;
       for( int i=0; i<word.length(); i++) {
        char ch = word.charAt(i);
        if(!node.containsKey(ch)) return false;
        node = node.moveToNewCrtedNode(ch);
       }
       return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
       for( int i=0; i<prefix.length(); i++) {
        char ch = prefix.charAt(i);
        if(!node.containsKey(ch)) return false;
        node = node.moveToNewCrtedNode(ch);
       }
       return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */