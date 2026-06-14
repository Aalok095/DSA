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
    public ListNode reverseList(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode Next = null;
        while(curr!=null){
            Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
    public int pairSum(ListNode head) {
        if(head.next.next==null) return head.val+head.next.val;
         ListNode slow = head;
         ListNode fast = head;
         while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
         }
         ListNode newHead = reverseList(slow);
         ListNode temp = head;
         int sum = 0;
         while(newHead!=null){
            sum = Math.max(sum,temp.val+newHead.val);
            temp = temp.next;
            newHead = newHead.next;
         }
         return sum;
    }
}