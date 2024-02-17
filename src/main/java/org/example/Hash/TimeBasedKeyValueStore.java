package org.example.Hash;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {
    Map<String, TreeMap<Integer, String>> map = null;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = null;
        if (map.get(key) == null) {
            treeMap = new TreeMap<>();
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        } else {
            treeMap = map.get(key);
            treeMap.put(timestamp, value);
            map.put(key, treeMap);
        }
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) {
            return null;
        }
        if(treeMap.floorKey(timestamp)!=null){
            return treeMap.get(treeMap.floorKey(timestamp));
        }
        return null;
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore timeBasedKeyValueStore = new TimeBasedKeyValueStore();
        timeBasedKeyValueStore.set("love", "high", 10);
        timeBasedKeyValueStore.set("love", "low", 20);
        timeBasedKeyValueStore.get("love", 5);
        timeBasedKeyValueStore.get("love", 10);
        timeBasedKeyValueStore.get("love", 15);
        timeBasedKeyValueStore.get("love", 20);
        timeBasedKeyValueStore.get("love", 25);
    }
}
