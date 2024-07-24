public class Node{
    Node[] link = new Node[26];
    boolean end;
    int value;

    boolean containsKey(char ch){
        return link[ch -'a'] != null;
    }
    void crtNode(char ch,  Node node) {
        link[ch -'a'] = node;
    }

    Node moveNode(char ch){
        return link[ch - 'a'];
    }
    void setEnd(){
        end = true;
    }
    boolean isEnd(){
        return end;
    }

}

class MapSum extends Node {
    public Node root;
    public HashMap<String, Integer> map;
    public MapSum() {
        root = new Node();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        Node node = root;
        for(char ch : key.toCharArray()){
            if(!node.containsKey(ch)){
                node.crtNode(ch, new Node());
            }
            node = node.moveNode(ch);
        }
        node.setEnd();
        node.value = val;
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        Node node = root;
        for(char ch : prefix.toCharArray()){
            if(!node.containsKey(ch)){
                return 0;
            }
            node = node.moveNode(ch);
        }
        return dfs(node);
    }
    public int dfs(Node node){
        if(node == null) return 0;

        int sum=0;
        if(node.isEnd()) sum = node.value;
        else sum = 0;

        for(char ch='a'; ch<='z'; ch++){
            sum += dfs(node.moveNode(ch));
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */