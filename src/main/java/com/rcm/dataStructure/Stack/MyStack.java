package com.rcm.dataStructure.Stack;

public class MyStack {

    private StackNode _top; // Most recent element added to the stack
    private StackNode _bottom; // The very first element added to te stack
    private long _length;


    public MyStack() {
        this._top = null;
        this._bottom = null;
        this._length = 0;
    }

    /**
     * This method adds the new value to the top of the stack
     * @param val : string value to be added to the stack
     */
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

    /**
     * This method removes and returns the topmost value on the stack
     * @return
     */
    public String pop() {
        String popped = "";
        if(this._top != null) {
            popped =  this._top.value;
            this._top  = this._top.nextNode;
            this._length--;
            if(_length == 0) {
                this._bottom = this._top;
            }
            return popped;
        } else {
            return "Empty Stack";
        }
    }

    /**
     * This method returns the topmost value on the stack WITHOUT removing it
     * @return
     */
    public String peek() {
        if(this._top != null) {
            return this._top.value;
        } else {
            return "Stack is empty";
        }

    }

    /**
     * Check if the stack is empty
     * @return
     */
    public Boolean isEmpty() {
        if(this._top == null) {
            return true;
        } else {
            return false;
        }
    }

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
        System.out.println("Empty? "+stack.isEmpty());
        stack.push("Google");
        System.out.println("Empty? "+stack.isEmpty());
        stack.push("Udemy");
        stack.push("Twitter");
        System.out.println(stack);
        System.out.println("Peek ------>"+stack.peek());
        System.out.println(stack.pop());
        System.out.println("Peek ------>"+stack.peek());
        System.out.println(stack.pop());
        System.out.println("Peek ------>"+stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
//        stack.push("Twitter");
        System.out.println(stack);
    }
}
