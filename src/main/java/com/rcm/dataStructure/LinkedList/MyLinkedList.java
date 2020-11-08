package com.rcm.dataStructure.LinkedList;

public class MyLinkedList {

    private Node _head;
    private Node _tail;
    private long _length;


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
        this._tail.setNext(newNode);
        this._tail = newNode;
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
     * @param index
     * @param val
     */
    public void insert(int index, String val) {
        int x = 1;
        Node currentNode = this._head;
        Node previousNode = currentNode;
        if(index == 1) {
            prepend(val);
        } else if (x == this._length) {
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

    public void remove(int index) {
        int x = 1;
        Node currentNode = this._head;
        Node previousNode = currentNode;

            while(x<=this._length) {
                if(index == 1) {
                    this._head = currentNode.getNext();
                    this._length--;
                    break;
                } else if (x == index) {
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
        myLL.append("2");
        myLL.append("3");
        myLL.append("4");
        myLL.append("5");

        System.out.println("My Linked List :"+myLL);
        myLL.remove(1);
        System.out.println("My Linked List :"+myLL);
        myLL.remove(4);
        System.out.println("My Linked List :"+myLL);
    }

}
