TC Runtime 0ms
  Beats 100.00%

SC Complexity
  Memory 45.42MB
  Beats 66.91%

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
    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;

        while (temp != null ) {
            if(prev != null && prev.val == temp.val) {
                prev.next = temp.next;
            }
            else{
                prev = temp;
            }
            temp = temp.next;
        }

        return head;
    }
}
