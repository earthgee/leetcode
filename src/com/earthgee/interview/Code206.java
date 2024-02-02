package com.earthgee.interview;

public class Code206 {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode();
        while(head != null){
            ListNode current = head;
            head = head.next;
            current.next = newHead.next;
            newHead.next = current;
        }

        return newHead.next;
    }

}
