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
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode temp = head;
        while(temp!=null){
            while(!st.isEmpty() && st.peek()<temp.val) st.pop();
            st.push(temp.val);
            temp = temp.next;
        }
        while(!st.isEmpty()){
            ListNode top = new ListNode(st.pop());
            top.next = temp;
            temp = top;
        }
        return temp;
    }
}