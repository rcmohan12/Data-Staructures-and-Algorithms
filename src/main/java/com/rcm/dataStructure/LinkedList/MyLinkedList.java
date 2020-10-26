package com.rcm.dataStructure.LinkedList;

import org.w3c.dom.ls.LSOutput;

public class MyLinkedList {

    private LinkedNode _head;
    private LinkedNode _tail;
    private long _length;


    MyLinkedList(String val) {
        this._head = new LinkedNode();
        this._head.setVal(val);
        this._tail = this._head;
        this._length = 1;
    }


    @Override
    public String toString() {
        return "MyLinkedList{" +
                "_head=" + _head +
                ", _tail=" + _tail +
                '}';
    }
}

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
        MyLinkedList myLL = new MyLinkedList("Roopa");
        System.out.println("My Linked List :"+myLL);
    }

}
