/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        int i=0,sum = 0;
        ListNode curr = head.next;
        
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        int size = getSize(head);
        while(i<size && curr != null){
            while(curr.val != 0 && curr != null){
                i++;
                sum += curr.val;
                curr = curr.next;
            }
            tail.next = new ListNode(sum);
            tail = tail.next;
            curr = curr.next;
            sum =0;
        }
        return dummy.next;
    }
    public int getSize(ListNode head) {
        int size=0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        } 
        //System.out.println("Size = "+size);
        return size;
    }
}