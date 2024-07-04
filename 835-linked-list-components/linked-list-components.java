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
    public int numComponents(ListNode head, int[] nums) {
        if(head.next == null && nums.length == 1) return 1;
        boolean flag = false;
        int cnt=0; 
        ListNode curr = head;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        while(curr != null) {
            if(set.contains(curr.val)){
                if(!flag) {
                    cnt++;
                    flag = true;
                }
            }else {
                flag = false;
            }
            curr = curr.next;
        }
        return cnt;
    }
}