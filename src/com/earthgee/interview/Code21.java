package com.earthgee.interview;

public class Code21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null){
            return null;
        }

        if(list1==null){
            return list2;
        }

        if(list2==null){
            return list1;
        }

        ListNode node1=list1;
        ListNode node2=list2;
        ListNode head=new ListNode();
        ListNode tmp=head;

        while(node1!=null && node2!=null){
            if(node1.val <= node2.val){
                tmp.next=node1;
                node1=node1.next;
            } else {
                tmp.next=node2;
                node2=node2.next;
            }

            tmp=tmp.next;
            tmp.next=null;
        }

        if(node1 == null){
            tmp.next=node2;
        }

        if(node2 == null){
            tmp.next=node1;
        }

        return head.next;
    }

}
