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
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null,Next = null;
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);
        int max = head.val;
        ListNode curr = head;
        while(curr.next!=null){
            if(curr.next.val<max) curr.next = curr.next.next;
            else {
                curr = curr.next;
                max = curr.val;
            }
        }
        return reverse(head);
    }
}