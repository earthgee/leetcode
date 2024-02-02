package com.earthgee.interview;

import java.util.LinkedList;

public class Code155 {

    static class MinStack {
        LinkedList<Integer> stack;
        LinkedList<Integer> minStack;

        public MinStack() {
            stack=new LinkedList<>();
            minStack=new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(minStack.peek(), val));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
