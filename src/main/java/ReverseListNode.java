/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class ReverseListNode {// leetcode 206

    public ListNode reverseList(ListNode head) {//recursive
        return recur(head, null);
    }

    private ListNode recur(ListNode curr, ListNode pre) {
        if (curr == null) return pre;
        ListNode res = recur(curr.next, curr);
        curr.next = pre;
        return res;
    }

    public ListNode reverseList2(ListNode head) {//double pointer
        ListNode pre = null, tmp = null;
        ListNode curr = head;
        while (curr != null) {
            tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}