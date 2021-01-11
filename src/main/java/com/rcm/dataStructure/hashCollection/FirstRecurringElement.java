package com.rcm.dataStructure.hashCollection;
public class FirstRecurringElement extends HashMap{

    public FirstRecurringElement(int size) {
        super(size);
    }

    public static void main(String[] args) {
        System.out.println("Brute Force -->"+returnFirstRecurringElementBruteForce(new String[]{"roopa", "is", "roopa"}));
        System.out.println("Optimised -->"+returnFirstRecurringElementOptimised(new String[]{"roopa", "is", "roo"}));

    }

    // Time complexity O(n)
    public static String returnFirstRecurringElementBruteForce(String[] elements) {
        for(int i = 0; i < elements.length; i++) {
            for(int j = i+1; j<elements.length; j++) {
                if(elements[i].equals(elements[j])) {
                    return elements[i];
                }
            }
        }
        return "No Recurring elements";
    }

    public static String returnFirstRecurringElementOptimised(String[] elements) {
        FirstRecurringElement map = new FirstRecurringElement(elements.length);
        for(String elem : elements) {
            if(map.containsKeys(elem, map)) {
                return elem;
            } else {
                map.put(elem,elem);
            }
        }
        System.out.println(map.toString());
        return "No Recurring elements";
    }

    public boolean containsKeys(String key, FirstRecurringElement map) {
        int index = _hash(key);
        if(map.get_arr()[index] != null) {
            Item it = map.get_arr()[index];
            while(it != null) {
                if(it.get_key().equals(key)) {
                    return true;
                } else {
                    it = it.get_next();
                }
            }
        } else {
            return false;
        }
        return false;
    }
}
