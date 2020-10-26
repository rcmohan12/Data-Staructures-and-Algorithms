package com.rcm.dataStructure.LinkedList;

import org.w3c.dom.ls.LSOutput;

public class MyLinkedList {

    private LinkedNode _head;
    private LinkedNode _tail;
    private long _length;


    /**
     * Constructer initializing the head and the tail values.
     * When the LL is created for the first time, the head and the tail point to the same object
     * @param val
     */
    MyLinkedList(String val) {
        this._head = new LinkedNode();
        this._head.setVal(val);
        this._tail = this._head;
        this._length = 1;
    }

    /**
     * Use this method to add to the end of the LL
     * The head remains constant whereas the tail changes to refer to the last added value to the LL
     * @param val
     */
    public void append(String val) {
        LinkedNode newNode = new LinkedNode();
        newNode.setVal(val);
        this._tail.setNext(newNode);
        this._tail = newNode;
        _length++;
    }


    @Override
    public String toString() {
        return "MyLinkedList{" +
                "_head=" + _head +
                ", _tail=" + _tail +
                '}';
    }
}

/**
 * Object that acts a node that  will store the value to the list and a reference to the next node in the LL
 */
class LinkedNode {

    String val;
    LinkedNode next;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "LinkedNode{" +
                "val='" + val + '\'' +
                ", next=" + next +
                '}';
    }
}

class TestMyLinkedList {

    public static void main(String[] args) {
        MyLinkedList myLL = new MyLinkedList("Sie");
        myLL.append("ist");
        myLL.append("eine");
        myLL.append("Schone");
        myLL.append("Frau");
        System.out.println("My Linked List :"+myLL);
    }

}
