package org.example;


import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN (write your solution here)
public class Cache {

    private int maxSize;
    private Map<String, String> cache;

    Cache(int maxSize) {
        this.maxSize = maxSize;
        this.cache = new LinkedHashMap<String, String>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
                return cache.size() > maxSize;
            }
        };
    }

    public void put(String request, String response) {
        cache.put(request, response);
    }

    public String get(String request) {
        return cache.get(request);
    }
}