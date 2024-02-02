package com.earthgee.interview;

public class Code24 {

    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }

        ListNode virtual=new ListNode();
        virtual.next=head;
        ListNode move=virtual;

        while(move.next!=null && move.next.next!=null){
            ListNode second=move.next.next;
            move.next.next=second.next;
            second.next=move.next;
            move.next=second;

            move=move.next.next;
        }

        return virtual.next;
    }

}
