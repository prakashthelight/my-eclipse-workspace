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
        if (queue.contains(key)) {
            queue.remove(Integer.valueOf(key));
            queue.addFirst(key);
            return map.get(key);
        } else {
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            queue.removeLast();
            queue.addFirst(key);
        } else {
        	
            if (this.capacity == queue.size()) {
                map.remove(queue.removeLast());
            }
            
            map.put(key, value);
            queue.addFirst(key);
        }
    }
}