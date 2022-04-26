package DoublePointer;


//https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/505fc7/

class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null){
            return null;
        }
        if(head.val == val) return head.next;
        ListNode curr = null;
        ListNode next = head;

        while(next != null){
            curr = next;
            next = next.next;
            if(next != null && next.val == val){
                break;
            }
        }

        if(next != null) {
            curr.next = next.next;
        }
        return head;

    }

    public ListNode deleteNode2(ListNode head, int val) {
        if(head.val==val) return head.next;

        ListNode temp = head;
        while(temp.next!=null){
            if(temp.next.val==val){
                temp.next = temp.next.next;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}