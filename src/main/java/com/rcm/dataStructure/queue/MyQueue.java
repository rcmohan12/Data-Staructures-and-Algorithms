package com.rcm.dataStructure.queue;


public class MyQueue {

    private QueueNode _first; // Most recent element added to the queue
    private QueueNode _last; // The very first element added to the queue
    private long _length;

    MyQueue() {
        this._first = this._last;
    }

    public void enqueue(String val) {
        QueueNode node = new QueueNode();
        node.setVal(val);
        if(this._first == null) {
            this._first = node;
            this._last = this._first;
        } else {
            this._first.setNext(node);
            this._first = node;
        }
        _length++;
    }

    public String dequeue() {
        if(this._last != null) {
            String val = this._last.getVal();
            QueueNode bottom = this._last;
            this._last = this._last.getNext();
            bottom.setNext(null);
            _length--;
            return val;
        } else {
            return "Queue is empty";
        }
    }

    public String peek() {
        if(this._last != null) {
            return this._last.getVal();
        } else {
            return "Queue is empty";
        }
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "_top=" + _first +
                ", _bottom=" + _last +
                ", _length=" + _length +
                '}';
    }
}

class QueueNode {

    String val;
    QueueNode next;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "QueueNode{" +
                "val='" + val + '\'' +
                ", next=" + next +
                '}';
    }
}

class TestMyQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue("first");
        queue.enqueue("second");
        queue.enqueue("third");
        System.out.println("Peek---->"+queue.peek());
        System.out.println(queue.dequeue());
        System.out.println("Peek---->"+queue.peek());
        System.out.println(queue.dequeue());
        System.out.println("Peek---->"+queue.peek());
        System.out.println(queue.dequeue());
        System.out.println("Peek---->"+queue.peek());
        System.out.println(queue.dequeue());

        System.out.println(queue);
    }
}
