package com.rcm.dataStructure.LinkedList;

import java.util.Date;

public class MyLinkedList {

    private Node _head;
    private Node _tail;
    private long _length;

    MyLinkedList() {
    }

    /**
     * Constructer initializing the head and the tail values.
     * When the LL is created for the first time, the head and the tail point to the same object
     * @param val
     */
    MyLinkedList(String val) {
        this._head = new Node();
        this._head.setVal(val);
        this._tail = this._head;
        this._length = 1;
    }

    /**
     * Use this method to add to the end of the LL
     * The head remains constant whereas the tail changes to refer to the last added value to the LL
     * Time complexity - O(1)
     * @param val
     */
    public void append(String val) {
        Node newNode = new Node();
        newNode.setVal(val);

        if(this._head == null && this._tail == null ) {
            this._head = newNode;
            this._tail = this._head;
        } else {
            this._tail.setNext(newNode);
            this._tail = newNode;
        }

        this._length++;
    }

    /**
     * Use this method to add a value to the beginning of the LL
     * The tail remains the same and the head changes as and when a new value is added to the beginning of the LL
     * Time complexity - O(1)
     * @param val
     */
    public void prepend(String val) {
        Node newNode = new Node();
        newNode.setVal(val);
        newNode.setNext(this._head);
        this._head = newNode;
        this._length++;
    }

    /**
     * Use this method to add a value at a specific index position in the linked list
     * Time complexity - O(n)
     * @param index
     * @param val
     */
    public void insert(int index, String val) {
        int x = 1;
        Node currentNode = this._head;
        Node previousNode = currentNode;
        if(index == 1) {
            prepend(val);
        } else if (index == this._length) {
            append(val);
        } else if (index < 0 || index > this._length) {
            System.out.println("Not a valid index position");
        } else {
            while(x<=this._length) {
                if(x == index) {
                    Node newNode = new Node();
                    newNode.setVal(val);
                    previousNode.setNext(newNode);
                    newNode.setNext(currentNode);
                    this._length++;
                    return;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
                x++;
            }
        }
    }


    /**
     * Use this method to remove a value in the LL at a specified index location
     * Time complexity - O(n)
     * @param index
     */
    public void remove(int index) {
        int x = 1;
        Node currentNode = this._head;
        Node previousNode = currentNode;

            while(x<=this._length) {
                if(index == 1) {
                    this._head = currentNode.getNext();
                    this._length--;
                    break;
                } else if (index == index) {
                    if(index == this._length) {
                        previousNode.setNext(null);
                        this._tail = previousNode;
                    } else {
                        previousNode.setNext(currentNode.getNext());
                    }
                    this._length--;
                    break;
                } else {
                    previousNode = currentNode;
                    currentNode = currentNode.getNext();
                }
                x++;
            }
    }

    /**
     * Reversing the LL by creating a new one
     * Time complexity - O(n)
     * Space complexity - O(n)
     */
    public void reverse() {
        Node currentHead = this._head;
        MyLinkedList newLL = new MyLinkedList(currentHead.getVal());
        while (currentHead.next != null) {
            currentHead = currentHead.next;
            newLL.prepend(currentHead.getVal());
        }

        this._head = newLL._head;
        this._tail = newLL._tail;
    }

    /**
     * No new LL is created
     * Time complexity - O(n)
     * Space complexity - O(1)
     * Think of the reversal as progressively pointing the 'next' object to the previous one
     * start : START --> 1 --> 2 --> 3 --> 4 --> END
     * step 1 : START <-- 1 --> 2 --> 3 --> 4 --> END
     * step 2 : START <-- 1 <-- 2 --> 3 --> 4 --> END
     * step 3 : START <-- 1 <-- 2 <-- 3 --> 4 --> END
     * and so on ......
     * Check video - https://www.youtube.com/watch?v=O0By4Zq0OFc
     */
    public void reverseOptimised() {
        Node previousNode = null;
        Node currentNode = this._head;
        this._tail = currentNode; // the current head becomes the new tail
        Node nextNode = null;
        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        this._head = previousNode; // the current tail becomes the new head
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
class Node {

    String val;
    Node next;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
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
        MyLinkedList myLL = new MyLinkedList("1");
        for(int x = 2; x < 100000; x++) {
            myLL.append(String.valueOf(x));
        }
        Long start = System.currentTimeMillis();
        myLL.reverse();
        Long end = System.currentTimeMillis();
        System.out.println("Time taken: "+(end - start));

        Long start1 = System.currentTimeMillis();
        myLL.reverseOptimised();
        Long end1 = System.currentTimeMillis();
        System.out.println("Time taken: "+(end1 - start1));
    }

}
