package org.HashTables;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

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
        String palindrom = "madam";
        HashTables isPalindrom = new HashTables("3").isPalindrom(palindrom);
        System.out.println(isPalindrom);

        //task 4
        LinkedHashMap<String, Integer> map1 = new LinkedHashMap<>();
        map1.put("Андрей", 78);
        map1.put("Никита", 69);
        map1.put("Артем", 12345);
        LinkedHashMap<String,Integer> map2 = new LinkedHashMap<>();
        map2.put("Андрей", 78);
        map2.put("Олег", 78);
        HashTables mergesTable = new HashTables("4").mergeTables(map1, map2);
        System.out.println(mergesTable);

        List<LinkedHashMap<String,Integer>> arrayOfHashTables = new ArrayList<LinkedHashMap<String,Integer>>();

        arrayOfHashTables.add(map);
        arrayOfHashTables.add(map1);
        arrayOfHashTables.add(map2);
        HashTables mergedArrTables = new HashTables("5").mergeTables(arrayOfHashTables);
        System.out.println(mergedArrTables);

    }
}
