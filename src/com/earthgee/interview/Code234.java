package com.earthgee.interview;

public class Code234 {

    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head.next;

        while(fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }

        ListNode reverseNode=slow;
        ListNode tempHead=new ListNode();
        ListNode tmp=reverseNode.next;
        reverseNode.next=null;
        while(tmp!=null){
            ListNode node=tmp;
            tmp=tmp.next;
            node.next=tempHead.next;
            tempHead.next=node;
        }

        ListNode compareFirst=head;
        ListNode compareSecond=tempHead.next;
        while(compareFirst!=null && compareSecond!=null){
            if(compareFirst.val!= compareSecond.val){
                return false;
            }
            compareFirst=compareFirst.next;
            compareSecond=compareSecond.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Code234 code234=new Code234();
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(2);
        ListNode node4=new ListNode(1);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        System.out.println(code234.isPalindrome(node1));
    }

}
