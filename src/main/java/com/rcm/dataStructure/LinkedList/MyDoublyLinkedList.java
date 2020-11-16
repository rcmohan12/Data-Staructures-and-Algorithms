package com.rcm.dataStructure.LinkedList;


public class MyDoublyLinkedList {

    private DLLNode _head;
    private DLLNode _tail;
    private long _length;

    /**
     * Constructer initializing the head and the tail values.
     * When the DLL is created for the first time, the head and the tail point to the same object
     * @param val
     */
    MyDoublyLinkedList(String val) {
        this._head = new DLLNode();
        this._head.setVal(val);
        this._tail = this._head;
        this._length = 1;
    }


    /**
     * Append function to add to add values to the end of the DLL.
     * The head remains the same but the newly added value becomes the tail
     * Time complexity O(1)
     * @param val
     */
    public void append(String val) {
        DLLNode node = new DLLNode();
        node.setVal(val);
        node.setPrevious(this._tail);
        this._tail.setNext(node);
        this._tail = node;
        _length++;
    }

    //prepend

    //insert
    //remove


    @Override
    public String toString() {
        return "MyDoublyLinkedList{" +
                "_head= { value = " + _head.getVal() + " next = " + _head.getNext() + " prev = " + _head.getPrevious() + "}" +
                ", _tail= { value = " + _tail.getVal() + " next = " + _tail.getNext() + " prev = " + _tail.getPrevious() + "}" +
                ", _length=" + _length +
                '}';
    }
}

class DLLNode {

    String val;
    DLLNode next;
    DLLNode previous;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setNext(DLLNode next) {
        this.next = next;
    }

    public DLLNode getPrevious() {
        return previous;
    }

    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }


}

class TestMyDoublyLinkedList {
    public static void main(String[] args) {
        MyDoublyLinkedList dll = new MyDoublyLinkedList("1");
        dll.append("2");
        dll.append("3");
        dll.append("4");

        System.out.println(dll);
    }
}
