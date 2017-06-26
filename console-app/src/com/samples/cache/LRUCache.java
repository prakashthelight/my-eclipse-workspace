package com.samples.cache;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    
    private HashMap<Integer, Integer> map = new HashMap<>();
    private LinkedList<Integer> queue = new LinkedList<Integer>();
    private int capacity;
    

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            queue.remove(Integer.valueOf(key));
            queue.addLast(key);
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            queue.removeFirst();
            queue.addLast(key);
        } else {
            if (this.capacity == map.size()) {
                map.remove(queue.removeFirst());
            }
            
            map.put(key, value);
            queue.addLast(key);
        }
    }
}