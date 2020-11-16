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
        System.out.println("calling append");
        DLLNode node = new DLLNode();
        node.setVal(val);
        node.setPrevious(this._tail);
        this._tail.setNext(node);
        this._tail = node;
        _length++;
    }

    /**
     * Add value to the beginning of the DLL
     * The newly added value becomes the new head
     * Complexity O(1)
     * @param val
     */
    public void prepend(String val) {
        System.out.println("prepending");
        DLLNode node = new DLLNode();
        node.setVal(val);
        this._head.setPrevious(node);
        node.setNext(this._head);
        this._head = node;
        _length++;
    }

    /**
     * Use this method to add a value at a specific index position in the linked list
     * Time complexity - O(n)
     * @param index
     * @param val
     */
    public void insert(int index, String val) {
        int x = 1;
        DLLNode currentNode = this._head;
        if(index == 1) {
            prepend(val);
        } else if (index == this._length) {
            append(val);
        } else if (index < 0 || index > this._length) {
            System.out.println("Not a valid index position");
        } else {
            while(x<=this._length) {
                if(x == index) {
                    DLLNode newNode = new DLLNode();
                    newNode.setVal(val);
                    currentNode.getPrevious().setNext(newNode);
                    newNode.setNext(currentNode);
                    this._length++;
                    return;
                } else {
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
        DLLNode currentNode = this._head;
        while(x<=this._length) {
            if(index == 1) {
                this._head = currentNode.getNext();
                this._head.setPrevious(null);
                this._length--;
                break;
            } else if (x == index) {
                if(index == this._length) {
                    this._tail = this._tail.previous;
                    this._tail.setNext(null);
                } else {
                    currentNode.getPrevious().setNext(currentNode.getNext());
                    currentNode.getNext().setPrevious(currentNode.getPrevious());
                }
                this._length--;
                break;
            } else {
                currentNode = currentNode.getNext();
            }
            x++;
        }
    }


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
        dll.prepend("4");
        dll.insert(4, "7");
        dll.insert(1, "11");
        dll.insert(24, "34");
        dll.remove(1);

        System.out.println(dll);
    }
}
