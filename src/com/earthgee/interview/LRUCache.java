package com.earthgee.interview;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class LNode {
        int key;
        int value;
        LNode prev;
        LNode next;

        public LNode() {}
        public LNode(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    private Map<Integer, LNode> cache=new HashMap<>();
    private int size;
    private int capacity;
    private LNode head,tail;

    public LRUCache(int capacity) {
        this.size=0;
        this.capacity=capacity;
        head=new LNode();
        tail=new LNode();
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key) {
        LNode node=cache.get(key);
        if(node==null){
            return -1;
        }

        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        LNode node=cache.get(key);
        if(node==null) {
            LNode newNode=new LNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size>capacity){
                LNode tail=removeTail();
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value=value;
            moveToHead(node);
        }
    }

    private void moveToHead(LNode node){
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(LNode node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    private void addToHead(LNode node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }

    private LNode removeTail(){
        LNode res=tail.prev;
        removeNode(res);
        return res;
    }

}
