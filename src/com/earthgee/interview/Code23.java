package com.earthgee.interview;

public class Code23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
            return null;
        }

        ListNode root=new ListNode();
        ListNode cur=root;
        int size=lists.length;
        ListNode[] point=new ListNode[size];
        for(int i=0;i<size;i++){
            point[i]=lists[i];
        }

        while(true){
            int index=-1;
            int min=Integer.MAX_VALUE;

            for(int i=0;i<size;i++){
                if(point[i]==null){
                    continue;
                }

                if(point[i].val < min){
                    index=i;
                    min=point[i].val;
                }
            }

            if(index==-1){
                break;
            }

            ListNode tmp=point[index];
            point[index]=point[index].next;
            cur.next=tmp;
            cur=cur.next;
        }

        return root.next;
    }

}
