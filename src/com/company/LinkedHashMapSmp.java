package com.company;

import java.util.LinkedHashMap;

/*
LinkedHashMap is a HashMap maintains insertion order.
This behavior is so useful while designing an LRU cache.
LRU cache evicts least recently used key when cache is full.
Any key called with get() method can be removed and added back. That way always used keys are getting front.

 */
public class LinkedHashMapSmp {

    public static class LRUCache{
        LinkedHashMap<Integer,Integer> memory;
        int capacity;

        public LRUCache(int capacity) {
            memory=new LinkedHashMap<>(capacity);
            this.capacity=capacity;
        }

        public int get(int key) {
            Integer result = memory.getOrDefault(key,-1);
            if(result!=-1){
                memory.remove(key);
                memory.put(key,result);
            }
            return result;
        }

        public void put(int key, int value) {
            Integer old = memory.get(key);
            if(old!=null)
                memory.remove(key);
            else if(memory.size()==this.capacity)
                memory.remove(memory.entrySet().iterator().next().getKey());

            memory.put(key,value);
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,100);
        cache.put(2,200);
        cache.put(3,300);
        cache.get(2);
        cache.put(4,400);
        System.out.println(cache);
    }

}
