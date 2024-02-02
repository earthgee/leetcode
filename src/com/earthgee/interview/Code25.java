package com.earthgee.interview;

public class Code25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root=new ListNode();
        ListNode cur=root;

        ListNode left;
        ListNode right=head;
        int length;

        boolean hasTail;

        while(true){
            left=right;
            length=k;
            while(length>0 && right!=null){
                right=right.next;
                length--;
            }

            if(length>0){
                hasTail=true;
                break;
            }

            while(left!=right){
                ListNode tmp=left;
                left=left.next;
                tmp.next=cur.next;
                cur.next=tmp;
            }

            while(cur.next!=null){
                cur=cur.next;
            }
        }

        if(hasTail){
            cur.next=left;
        }

        return root.next;
    }

    public static void main(String[] args) {
        Code25 code25=new Code25();
        ListNode head=new ListNode(1);
        ListNode two = head.next= new ListNode(2);
        ListNode three = two.next= new ListNode(3);
        ListNode four = three.next = new ListNode(4);
        ListNode five = four.next = new ListNode(5);
        code25.reverseKGroup(head, 3);
    }

}
