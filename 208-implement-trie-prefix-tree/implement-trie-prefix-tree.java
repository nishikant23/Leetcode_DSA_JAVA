class Node {
    Node arr[] = new Node[26];
    boolean flag = false;

    public Node() {

    }
    public boolean containsKey(char ch) {
        return (arr[ch -'a'] != null);
    }
    public void crtNode(char ch, Node node) {
        arr[ch - 'a'] = node; //new node created at arr[null postn]
    }

    public Node moveNodeToCurr(char ch) {
        return arr[ch - 'a']; //moving RefNode to current created new node
    }
    public void setEnd() {
        flag  = true;
    }
    public boolean isEnd() {
        return flag;
    }
}

class Trie extends Node {
    private Node root;
    public Trie() {
        root  = new Node();
    }
    
    public void insert(String word) {
        Node node  = root;
        for(int  i=0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.crtNode(word.charAt(i), new Node());
            }
            node = node.moveNodeToCurr(word.charAt(i));
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node  = root;
        for(int  i=0; i<word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false; //if char not found
            }
            node = node.moveNodeToCurr(word.charAt(i));
        }

        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node  = root;
        for(int  i=0; i<prefix.length(); i++){
            if(!node.containsKey(prefix.charAt(i))){
                return false; //if char not found
            }
            node = node.moveNodeToCurr(prefix.charAt(i));
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