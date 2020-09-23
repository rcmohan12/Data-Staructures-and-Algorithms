package com.rcm.dataStructure.arrays;

public class ArrayListImpl {
    private int length;
    private int[] intArray;

    /**
     * Create an array with initial size of 2
     * length - used to keep track of the last element position of the array
     */
    public ArrayListImpl() {
        this.length = 0;
        this.intArray = new int[2];
    }

    /**
     * Return the element at the specified index
     */
    public int get(int index) {
        return this.intArray[index];
    }

    /**
     * Add int value to the end of the array
     * @param val : int value tobe added
     */
    public void add(int val) {
        if(this.length == this.intArray.length) {
            reSize();
        }
        this.intArray[length] = val;
        this.length++;
    }

    /**
     * Used to create a new array of larger capacity and copy over the contents of the old array(that is full)
     */
    private void reSize() {
        int[] tempArray = this.intArray;
        this.intArray = new int[4];
        for(int i = 0; i< tempArray.length; i++) {
            this.intArray[i] = tempArray[i];
        }
    }

    /**
     * Removes element at the specified index location
     * @param index : index position at which a value needs to be removed
     * @return : value removed at index position
     */
    private int remove(int index) {
        int val = this.intArray[index];
        shiftElements(index);
        length--;
        return val;
    }

    private void shiftElements(int index) {
        for(int i=index; i<this.intArray.length; i++) {
            this.intArray[i] = this.intArray[i++];
        }
    }

    public static void main(String[] args) {
        ArrayListImpl ai = new ArrayListImpl();
        ai.add(12);
        ai.add(12);
        ai.add(12);
        ai.add(12);
        for (int i =0; i<ai.intArray.length; i++) {
            System.out.print(ai.intArray[i] + ", ");
        }
        ai.remove(2);
        System.out.print("after removal");
        for (int i =0; i<ai.intArray.length; i++) {
            System.out.print(ai.intArray[i] + ", ");
        }
    }
}
