package com.rcm.dataStructure.hashCollection;

import java.util.Iterator;

/**
 * Custom implementation for a HashMap that holds Strings as keys and values
 * No resizing
 *
 */
public class HashMap {

    /*initial size of the hash map*/
    private int _size;

    /*array that will act as buckets to hold the entries*/
    private Item[] _arr;


    public HashMap(int size) {
        this._size = size;
        this._arr = new Item[size];
    }

    /**
     * Generate hash code (and eventually the index position in the array) for String keys.
     * */
    private int _hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int x = 0; x < keyChars.length; x++) {
            hash = ((hash +Character.getNumericValue(keyChars[x])) * x)  % _size;
        }
        return hash;
    }

    /**
     * Insert the object into the array using the hash key
     * Time complexity O(1)
     * */
    public void put(String key, String value) {
        int index = _hash(key);
        Item i = new Item(key, value);
        if(_arr[index] == null) {
            _arr[index] = i;
        } else {
            appendToBucket(_arr[index], i);
        }
    }

    /** Add to the bucket (array index position) if a new entry is made that happens to have the same key as another entry
     * */
    private void appendToBucket(Item existing, Item newItem) {
        if(existing.get_next() != null) {
            appendToBucket(existing.get_next(), newItem);
        } else {
            existing.set_next(newItem);
            return;
        }
    }

    /** Retrieve the record from the Data structure
     * Time complexity O(1)
     * */
    public Item get(String key) {
        int index = _hash(key);
        Item seek = null;
        if(_arr[index].get_next() == null && _arr[index].get_key().equals(key)) {
            seek = _arr[index];
        } else {
            seek = _arr[index].get_next();
            while (seek != null) {
                if (seek.get_key().equals(key)) {
                    break;
                } else {
                    seek = seek.get_next();
                }

            }
        }
        return seek;
    }

    public static void main(String[] args) {
        HashMap t = new HashMap(10);
        t.put("roopa", "C");
        t.put("roopa", "mohan");
        t.put("apfel", "saft");
        t.put("obst", "salat");
        t.put("", "");
        for(Item i : t._arr) {
            System.out.println(i);
        }
        System.out.println("Found -------------------->"+t.get("apfel"));
    }

}

class Item {
    private String _key;
    private String _value;
    private Item _next;

    public Item(String key, String value) {
        this._key = key;
        this._value = value;
    }

    public String get_value() {
        return _value;
    }

    public String get_key() {
        return _key;
    }

    public Item get_next() {
        return _next;
    }

    public void set_next(Item item) {
        this._next = item;
    }

    @Override
    public String toString() {
        return "Item{" +
                "_key='" + _key + '\'' +
                ", _value='" + _value + '\'' +
                ", _next=" + _next +
                '}';
    }
}
