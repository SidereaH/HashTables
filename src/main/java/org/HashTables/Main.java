package org.HashTables;

import java.util.ArrayList;
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
        String palindrom = "nemadam";
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

        //task5
        List<LinkedHashMap<String,Integer>> arrayOfHashTables = new ArrayList<>();

        arrayOfHashTables.add(map);
        arrayOfHashTables.add(map1);
        arrayOfHashTables.add(map2);

        HashTables mergedArrTables = new HashTables("5").mergeTables(arrayOfHashTables);
        System.out.println(mergedArrTables);

        //task 6 Реализуйте алгоритм проверки, есть ли в двух различных хэш-таблицах совпадающие ключи или значения.
        HashTables comparedTables = new HashTables("6").compareTables(map1, map2);
        System.out.println(comparedTables);


        //task 7 Напишите программу, которая будет принимать на вход список чисел и строить хэш-таблицу, где ключом будет число, а значением - его квадрат.
        ArrayList<Integer> intlist = new ArrayList<>();
        intlist.add(6);
        intlist.add(7);
        intlist.add(8);
        intlist.add(9);
        intlist.add(10);
        HashTables toHashTableFromIntList = new HashTables("7").createHashMapFromIntArr(intlist);
        System.out.println(toHashTableFromIntList);


        //task 8 Разработайте функцию, которая будет принимать на вход хэш-таблицу и удалять из нее все ключи, соответствующие четным значениям.
        LinkedHashMap<Integer,Integer> intmap;
        intmap =toHashTableFromIntList.intAbsMap(intlist);
        HashTables removedEvenNums = new HashTables("8").removeEvenNums(intmap);
        System.out.println(removedEvenNums);

        //task 9 Напишите функцию, которая будет принимать на вход две хэш-таблицы и возвращать новую, содержащую только те ключи, которые есть в обеих таблицах, а значения перемножаться.

        LinkedHashMap<Integer, Integer> intmap2 = (LinkedHashMap<Integer, Integer>) intmap.clone();
        intmap2.put(2,4);
        HashTables comapreInts = new HashTables("9").compareIntTablesWithExistingKeys(intmap, intmap2);
        System.out.println(comapreInts);

    }
}
