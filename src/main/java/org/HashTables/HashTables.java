package org.HashTables;
import java.awt.desktop.SystemEventListener;
import java.util.*;

import static javax.swing.UIManager.put;

public class HashTables {
    private String task;
    private String[] stringArray;
    private LinkedHashMap<String, Integer> map;
    private LinkedHashMap<String, Integer> sMap;
    private String palindrom;
    private List<LinkedHashMap<String,Integer>> arraysOfMaps;
    private LinkedHashMap<String, Integer> mergedArrMap = new LinkedHashMap<>();

    public HashTables(String task){
        this.task = task;
    }
    public HashTables getHashFromStrings(String[] arr){
        this.stringArray = arr;
        return this;
    }
    public HashTables getSortedKeySet(LinkedHashMap<String, Integer> map){
        this.map = map;
        return this;
    }
    public HashTables isPalindrom(String palindrom){
        this.palindrom = palindrom;
        return this;
    }
    public HashTables mergeTables(LinkedHashMap<String, Integer> map1, LinkedHashMap<String,Integer> map2){
        this.map = map1;
        this.sMap = map2;
        return this;
    }
    public HashTables mergeTables(List<LinkedHashMap<String,Integer>> arrayOfMaps){
        this.arraysOfMaps = arrayOfMaps;
        return this;
    }

    @Override
    public String toString(){
        switch (task){
            case "1"-> {
                return String.format(
                        """
                        Задание: %s,
                        Массив строк: %s,
                        Хеш-таблица: %s.""",
                        task,
                        Arrays.toString(stringArray),
                        getMapFromStringList(stringArray)
                );
            }
            case "2" -> {
                return String.format(
                        """
                        Задание: %s,
                        Список неотсортированных ключей: %s,
                        Список отсортированных ключей: %s.""",
                        task,
                        map.keySet(),
                        Arrays.toString(getSortedKeys(map))
                );
            }
            case "3" -> {
                return String.format("""
                        Задание: %s,
                        Слово для проверки: %s,
                        Палиндром? - %s
                        
                        """,
                        task,
                        palindrom,
                        hashTableFromString(palindrom));

                //Arrays.toString(new ArrayList[]{isPalindromFromHash(palindrom)}));
            }
            case "4" -> {
                return String.format("""
                        Задание: %s,
                        Соединеные таблицы: %s
                        """,
                        task,
                        mergeTable(map, sMap));
            }
            case "5" ->{
                return String.format("""
                        Задание: %s,
                        Массив таблиц на вход: %s,
                        Соединеные таблицы: %s
                        """,
                        task,
                        Arrays.toString(new List[]{arraysOfMaps}),
                        mergeArrOfHashTables(arraysOfMaps));
            }
            case null, default -> {
                return String.format(
                        """
                         task %s doesn`t exist
                         have a nice day!
                         """,
                        task
                );
            }
        }
    }

    public LinkedHashMap<String, Integer> getMapFromStringList(String[] stringList){
        LinkedHashMap <String, Integer> map = new LinkedHashMap<>();
        int[] array_counts = new int[stringList.length];
        for(int i = 0; i < stringList.length; i++){
            array_counts[i] = countWordInArray(stringList[i],stringList);
            map.put(stringList[i], array_counts[i]);
        }

        return map;
    }
    private int countWordInArray(String word, String[] array){
        int length = array.length;
        int count = 0;
        for(int i = 0; i < length; i++){
            if(word == array[i]){
                count++;
            }
        }
        return count;
    }
    public String[] getSortedKeys(LinkedHashMap<String,Integer> map){
        String[] array = getIntArrayFromHashTable(map);
        array = quickSortString(array, 0, array.length-1);
        return array;
    }
    private String[] getIntArrayFromHashTable(LinkedHashMap<String, Integer> map){
        String[] keyArray = map.keySet().toArray(new String[0]);
        return  keyArray;
    }
    public static String[] quickSortString(String[] arr, int low, int high){
        if (low < high) {
            int pi = pivotString(arr, low, high);

            quickSortString(arr, low, pi - 1);
            quickSortString(arr, pi + 1, high);
        }
        return arr;
    }
    private static int pivotString(String[] arr, int less, int greater){
        int middle = less + (greater - less) / 2;
        String pivot = arr[middle];

        // Обмен опорного элемента с последним, чтобы использовать существующую логику
        String temp = arr[middle];
        arr[middle] = arr[greater];
        arr[greater] = temp;
        int i = (less - 1);
        for (int j = less; j < greater; j++) {
            if (arr[j].compareToIgnoreCase(pivot) < 0) {
                i++;

                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        temp = arr[i + 1];
        arr[i + 1] = arr[greater];
        arr[greater] = temp;
        return i + 1;
    }
    public boolean hashTableFromString(String word){
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        int countleft = 0;
        int countright = 0;
        for (int i = 0; i< word.length(); i++){
            if (i < word.length()/2 ){
                String character = String.valueOf(word.charAt(i));
                map.put(character + "l", i);
                countleft++;
            }
            else if (i >word.length()/2){
                String character = String.valueOf(word.charAt(i));
                map.put(character + "r", i);
                countright++;
            }
        }
        if(countleft == countright){
            return isPalindromFromHash(map);
        }
        return false;

    }

    private boolean isPalindromFromHash(LinkedHashMap<String, Integer> map){
        boolean isPal = false;
        ArrayList<String> keys = new ArrayList<>(map.keySet());
        ArrayList<String> keysLeft = new ArrayList<>();
        List<String> keysRev = new ArrayList<>();
        for (int i =0; i<keys.size(); i++){
            String temp = keys.get(i);
            temp = String.valueOf(temp.charAt(0));
            keys.set(i, temp);
        }
        int half = keys.size();
        while(keysLeft.size() != half/2){

            keysLeft.add(keys.get(keys.size()-1));
            keys.remove(keys.size() -1);
        }
        String listRev = String.join(", ", keys);
        String listLeft = String.join(", ", keysLeft);

        if (listRev.equals(listLeft)){
            isPal= true;
        }
        return  isPal;
    }

    public LinkedHashMap<String, Integer> mergeTable (LinkedHashMap<String, Integer> map1, LinkedHashMap<String, Integer> map2){

        LinkedHashMap<String, Integer> mergesMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            if (mergesMap.get(entry.getKey()) != null){

                Integer value = map.get(entry.getKey());

                mergesMap.put(entry.getKey(), value + entry.getValue());
            }
            else {
                mergesMap.put(entry.getKey(), entry.getValue());
            }
        }
        for(Map.Entry<String, Integer> entry : map2.entrySet()){
            if (mergesMap.get(entry.getKey()) != null){

                Integer value = mergesMap.get(entry.getKey());

                mergesMap.put(entry.getKey(), value + entry.getValue());
            }
            else {
                mergesMap.put(entry.getKey(), entry.getValue());
            }
        }
        return  mergesMap;
    }
    public LinkedHashMap<String,Integer> mergeArrOfHashTables( List<LinkedHashMap<String,Integer>> arrayOfMaps){
        for(int i =0; i < arrayOfMaps.size(); i++){

                mergedArrMap = mergeTable(mergedArrMap, arrayOfMaps.get(i));
        }
        return mergedArrMap;

//        for (int i =0 ; i < arrayOfMaps.size(); i++){
//            System.out.println("alo " + i);
//            if(i == arrayOfMaps.size()-1){
//                mergedArrMap = mergeTable(arrayOfMaps.get(i), arrayOfMaps.get(i));
//                mergedArrMap.put(arrayOfMaps.get(i))
//            }
//            else {
//                mergedArrMap = mergeTable(arrayOfMaps.get(i), arrayOfMaps.get(i + 1));
//            }
//
//
//        }
//        return mergedArrMap;

//        if(arrayOfMaps.size() <= 2){
//            return mergeTable(arrayOfMaps.get(0),arrayOfMaps.get(1));
//        }
//
//        return mergedArrMap = (mergeArrOfHashTables(arrayOfMaps));

    }
    static <K,V> K getKeyByIndex(LinkedHashMap<K,V> map, int index)
    {
        return map.keySet().stream().skip(index).findFirst().orElse(null);
    }
    private LinkedHashMap<String, Integer> addToHashMap(LinkedHashMap<String, Integer> mainMap, LinkedHashMap<String, Integer> whatToAdd){
        for(Map.Entry<String, Integer> entry : whatToAdd.entrySet()){
            if (mainMap.get(entry.getKey()) != null){

                Integer value = mainMap.get(entry.getKey());

                mainMap.put(entry.getKey(), value + entry.getValue());
            }
            else {
                mainMap.put(entry.getKey(), entry.getValue());
            }
        }
        return mainMap;
    }

}