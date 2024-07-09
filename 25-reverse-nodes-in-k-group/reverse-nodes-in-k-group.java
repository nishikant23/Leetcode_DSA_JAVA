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
    public ListNode reverseKGroup(ListNode head, int k) {
        return toArray(head, k);
    }
     public ListNode toArray(ListNode head, int k) {
        int[] arr = new int[getSize(head)];
        ListNode curr = head;
        int i=0;
        while(curr != null){
            arr[i] = curr.val;
            //System.out.println("arr["+i+"] = "+ arr[i]);
            i++;
            curr = curr.next;
        }
        //System.out.println("left = "+ left+" & Right = "+right);
        
        for(int ind=0; ind+k <= arr.length; ind+=k){
            int l=ind, r=ind+k-1;
            reverse(arr, l, r);
        }
        return toLL(arr);
    }
    public void reverse(int[] arr, int l, int r) {
        int k=0;
        k++;
        System.out.println("inside reverse function = " +  k);
        while(l<r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
    public ListNode toLL(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        for(int i=0; i<arr.length; i++) {
            curr.next = new ListNode(arr[i]);
            curr = curr.next;
        }
        return dummy.next;
    }
    public int getSize(ListNode head) {
        int size = 1;
        ListNode curr = head;
        while(curr.next != null){
            size++;
            curr = curr.next;
        }
        //System.out.println("Size of LL = "+ size);
        return size;
    }
}