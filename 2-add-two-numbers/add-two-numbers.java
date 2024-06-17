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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) { 
    //cary != 0, if both listnode is null, then we've to add non-zero carry at last of dummy
            
            int sum = carry; //whnevr add 2-nodes add carry with it,sum = carry
            if(l1 != null) {
                sum += l1.val; // sum = carray + l1.val
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val; // sum = carray + l1.val +l2.val
                l2  =l2.next;
            }
            carry = sum/10; //if two digit num formed the carry out
            tail.next = new ListNode(sum%10); //sum%10- add only single digit to tail.next
            tail = tail.next; //to move to next position
        }
        return dummy.next;
    }
}