package com.earthgee.interview;

public class Code19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root=new ListNode();
        root.next=head;
        ListNode tail=root;
        while(n>0){
            tail=tail.next;
            n--;
        }
        ListNode first=root;
        while(tail.next!=null){
            first=first.next;
            tail=tail.next;
        }

        first.next=first.next.next;
        return root.next;
    }

}
