
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0) return head;

        int len = 0;
        ListNode temp = head;

        while(temp!=null){
            len++;
            temp = temp.next;
        }

        k %= len;
        if(k==0) return head;

        temp = head;
        ListNode newHead = new ListNode(-1);
        int i = 0;
        while(i<len-k-1){
            temp = temp.next;
            i++;
        }
        newHead.next = temp.next;
        temp.next = null;

        ListNode temp2 = newHead;
        while(temp2.next!=null){
            temp2 = temp2.next;
        }

        temp2.next = head;
        return newHead.next;
    }
}