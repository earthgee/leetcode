package com.earthgee.interview;

public class Code142 {

    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next!=null){
                fast=fast.next.next;
            } else {
                return null;
            }
            if(slow == fast){
                ListNode ptr=head;
                while(ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }

        return null;
    }

}
