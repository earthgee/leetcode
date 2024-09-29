package com.earthgee.interview;

import java.util.HashMap;
import java.util.Map;

public class Code138 {

    Map<Node, Node> cacheNodes = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        if(!cacheNodes.containsKey(head)) {
            Node headNew = new Node(head.val);
            cacheNodes.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }

        return cacheNodes.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
