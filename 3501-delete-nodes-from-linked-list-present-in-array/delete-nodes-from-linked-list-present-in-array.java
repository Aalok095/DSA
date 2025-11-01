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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int ele : nums) set.add(ele);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        ListNode t = head;
        while(t!=null){
            if(!set.contains(t.val)) {
                temp.next = t;
                temp = temp.next;
            }
            t = t.next;
        }
        temp.next = null;
        return dummy.next;
    }
}