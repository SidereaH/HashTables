package org.HashTables;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("hi niggas! its hash tables");

        //task 1
        String[] strings = new String[] {"78", "79", "13", "78"};
        HashTables tableFromStringArr = new HashTables("1").getHashFromStrings(strings);
        System.out.println(tableFromStringArr);

        //task 2
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Z", 1);
        map.put("B", 2);
        map.put("A", 3);
        HashTables sortedKeysFromHashTable = new HashTables("2").getSortedKeySet(map);
        System.out.println(sortedKeysFromHashTable);

        //task 3






    }
}
