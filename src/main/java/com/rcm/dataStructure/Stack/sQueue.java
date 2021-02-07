package com.rcm.dataStructure.Stack;

import java.util.Stack;

public class sQueue {

    private Stack<Integer> _stack;
    public int size = 0;
    sQueue() {
        _stack = new Stack<>();
    }

    public void enQueue(Integer i) {
        _stack.push(i);
        size++;
    }

    public Integer deQueue() {
        int res = 0;
        int popped = 0;

        if(this._stack.size() == 0) {
            return 0;
        } else if(this._stack.size() == 1) {
            size--;
            return this._stack.pop();
        }

        popped = this._stack.pop();
        res = this.deQueue();
        this._stack.push(popped);


        return res;
    }
}

class TestStackyQueue {
    public static void main(String[] args) {
        sQueue queue = new sQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        queue.enQueue(5);
        queue.enQueue(6);

        for (int i = 0; i < queue.size; i++) {
            System.out.println(queue.deQueue());
        }

    }
}