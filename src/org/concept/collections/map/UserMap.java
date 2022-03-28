package org.concept.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class UserMap {

    public static void main(String[] arrays) {
        createData();
        System.out.println(unSortedMap);
        sortMapByKey();
    }

    public static final Map<String, Integer> unSortedMap = new HashMap<>();

    public static void createData() {

        unSortedMap.put("C3", 33);
        unSortedMap.put("D4", 44);

        unSortedMap.put("A1", 11);
        unSortedMap.put("B2", 22);

        unSortedMap.put("E5", 55);
        unSortedMap.put("F6", 66);
    }


    public static void sortMapByKey() {
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.putAll(unSortedMap);
        System.out.println(sortedMap);
        sortedMap.put("G7", 77);
        for (Map.Entry entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
