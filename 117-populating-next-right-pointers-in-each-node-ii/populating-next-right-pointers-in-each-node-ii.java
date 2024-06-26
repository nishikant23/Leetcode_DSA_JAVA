/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node head = root;
       
        while(head != null){
            Node dummy = new Node(); //So that each Level has its own LL 
            Node tail = dummy;
            while(head != null) { //Each LEVEL loop runs
            if(head.left != null) { //each root=head left & right checked 
                tail.next = head.left; // and added to tail's next position
                tail = tail.next;
            }
            if(head.right != null) {
                tail.next = head.right;
                tail = tail.next;
            }
            head  = head.next; //this head ptr goes 1by1 to each root of Tree
            }
            head = dummy.next;
        }
        return root;
    }
}