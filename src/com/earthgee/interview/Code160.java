package com.earthgee.interview;

public class Code160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        int lengthA = 0;
        while(a!=null){
            lengthA++;
            a=a.next;
        }
        ListNode b = headB;
        int lengthB = 0;
        while(b!=null){
            lengthB++;
            b=b.next;
        }

        int diff=Math.abs(lengthA-lengthB);
        if(lengthA>lengthB){
            a=headA;
            for(int i=0;i<diff;i++){
                a=a.next;
            }
            b=headB;
        } else if(lengthA<lengthB){
            a=headA;
            b=headB;
            for(int i=0;i<diff;i++){
                b=b.next;
            }
        } else {
            a=headA;
            b=headB;
        }

        while(a!=null){
            if(a==b){
                return a;
            } else {
                a=a.next;
                b=b.next;
            }
        }

        return null;
    }

}
