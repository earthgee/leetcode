package com.earthgee.interview;

public class Code2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=new ListNode();
        ListNode tmp=head;
        int add=0;
        ListNode n1=l1;
        ListNode n2=l2;
        while(n1!=null && n2!=null){
            int sum=n1.val+ n2.val+add;
            int val=sum%10;
            add=sum/10;
            ListNode newNode=new ListNode();
            newNode.val=val;
            tmp.next=newNode;
            tmp=newNode;
            n1=n1.next;
            n2=n2.next;
        }

        while(n1!=null){
            int sum=n1.val+add;
            int val=sum%10;
            add=sum/10;
            ListNode newNode=new ListNode();
            newNode.val=val;
            tmp.next=newNode;
            tmp=newNode;
            n1=n1.next;
        }

        while(n2!=null){
            int sum=n2.val+add;
            int val=sum%10;
            add=sum/10;
            ListNode newNode=new ListNode();
            newNode.val=val;
            tmp.next=newNode;
            tmp=newNode;
            n2=n2.next;
        }

        if(add==1){
            ListNode newNode=new ListNode();
            newNode.val=1;
            tmp.next=newNode;
            tmp=newNode;
        }

        return head.next;
    }

}
