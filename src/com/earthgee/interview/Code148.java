package com.earthgee.interview;

import java.util.List;

//链表排序
public class Code148 {

    public ListNode sortList(ListNode head) {
        if(head == null) {
            return null;
        }

        int length = 0;
        ListNode tmp = head;
        while(tmp != null) {
            length++;
            tmp = tmp.next;
        }

        ListNode root=new ListNode();
        root.next = head;
        for(int interval = 1;interval < length;interval <<= 1) {
            ListNode prev = root;
            ListNode curr = root.next;
            while(curr != null) {
                ListNode head1 = curr;
                for(int i=1;i<interval && curr.next != null;i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for(int i=1;i<interval && curr!=null && curr.next != null;i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = merge(head1, head2);
                prev.next = merged;
                while(prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }

        return root.next;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode root = new ListNode();
        ListNode tmp = root;
        while(head1!=null && head2!=null) {
            if(head1.val<=head2.val) {
                tmp.next = head1;
                tmp = tmp.next;
                head1 = head1.next;
            } else {
                tmp.next = head2;
                tmp = tmp.next;
                head2 = head2.next;
            }
        }

        if(head1!=null) {
            tmp.next = head1;
        }

        if(head2!=null) {
            tmp.next = head2;
        }


        return root.next;
    }

}
