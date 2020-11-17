package com.rcm.dataStructure.Stack;

public class MyStack {

    private StackNode _top;
    private StackNode _bottom;
    private long _length;


    public MyStack() {
        this._top = null;
        this._bottom = null;
        this._length = 0;
    }

    //push
    public void push(String val) {
        StackNode node = new StackNode(val);
        if(this._bottom == null) {
            this._bottom = node;
            this._top = node;
        } else {
            StackNode oldTop = this._top;
            this._top = node;
            this._top.nextNode = oldTop;
        }
        this._length++;
    }
    //pop

    public String pop() {
        String popped = "";
        if(this._top != null) {
            popped =  this._top.value;
            this._top  = this._top.nextNode;
            this._length--;
            return popped;
        } else {
            return "Empty Stack";
        }
    }
    //peek
    //isEmpty

    @Override
    public String toString() {
        return "MyStack{" +
                "_top=" + _top +
                ", _bottom=" + _bottom +
                ", _length=" + _length +
                '}';
    }
}

class StackNode {
    String value;
    StackNode nextNode;

    StackNode() {

    }

    public StackNode(String val) {
        this.value = val;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public StackNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(StackNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "value='" + value + '\'' +
                ", nextNode=" + nextNode +
                '}';
    }
}

class TestMyStack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push("Google");
        stack.push("Udemy");
        stack.push("Twitter");
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
