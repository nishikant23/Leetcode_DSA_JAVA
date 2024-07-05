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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode curr = head;
        if(curr.next.next == null) return new int[] {-1, -1};

        int[] ans = new int[2];
        int pos=1;
        List<Integer> ls = new ArrayList<>();

        while(curr.next != null && curr.next.next != null) {
            int p = curr.val, c = curr.next.val, n = curr.next.next.val;
            if(c>p && c>n) {
                pos++;
                ls.add(pos);
            }
            else if(c<p && c<n) {
                pos++;
                ls.add(pos);
            } else {
                pos++;
            }
            curr = curr.next;
        }
        if(ls.size()<=1) return new int[] {-1, -1};
        
        int lmax = ls.get(ls.size()-1) - ls.get(0);
        int lmin = Integer.MAX_VALUE;
         for(int i=1; i<ls.size(); i++) {
            lmin = Math.min(lmin, ls.get(i)-ls.get(i-1));
         }
         ans[0] = lmin;
         ans[1] = lmax;

         return ans;
    }
}