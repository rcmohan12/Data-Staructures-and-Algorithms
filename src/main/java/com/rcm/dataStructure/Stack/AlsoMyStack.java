package com.rcm.dataStructure.Stack;

import java.util.Arrays;

public class AlsoMyStack {

    private String _stackValues[];
    private int _length;

    AlsoMyStack() {
        this._stackValues = new String[5];
        this._length = 0;
    }

    /**
     * This method adds the new value to the top of the stack
     * @param va : string value to be added to the stack
     *           TODO : What happens when the array is full? resize?
     */
    public void push(String va) {
        _stackValues[_length] = va;
        _length++;
    }

    /**
     * This method removes and returns the topmost value on the stack
     * @return
     */
    public String pop() {
        if(_length != 0) {
            String val = _stackValues[_length-1];
            _stackValues[_length-1] = null;
            _length--;
            return val;
        } else {
            return "Stack is empty";
        }
    }

    /**
     * This method returns the topmost value on the stack WITHOUT removing it
     * @return
     */
    public String peek() {
        if(_length != 0) {
            return _stackValues[_length-1];
        } else {
            return "Stack is empty";
        }
    }

    @Override
    public String toString() {
        return "AlsoMyStack{" +
                "_stackValues=" + Arrays.toString(_stackValues) +
                ", _length=" + _length +
                '}';
    }
}

class TestingStack {
    public static void main(String[] args) {
        AlsoMyStack stack = new AlsoMyStack();
        stack.push("Google");
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
        stack.push("Twitter");
        stack.push("Keep");
        stack.push("Adding");
        stack.push("More");
        stack.push("and");
        stack.push("More");

        System.out.println(stack.toString());

    }
}
