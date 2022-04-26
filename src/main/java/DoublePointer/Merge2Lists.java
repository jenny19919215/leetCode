package DoublePointer;

public class Merge2Lists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 ==null || l2 ==null){
            return l1!=null? l1 : l2;
        }

        ListNode dum = new ListNode(0); ListNode curr = dum;
        ListNode i = l1;
        ListNode j = l2;
        ListNode temp =null;

        while(i!=null && j!=null){
            if(i.val <= j.val){
                curr.next = i;
                i = i.next;

            }else{
                curr.next = j;
                j=j.next;
            }
            curr = curr.next;
        }
        if(i!=null){
            curr.next = i;
        }else if(j !=null){
            curr.next = j;
        }
        return dum.next;

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
