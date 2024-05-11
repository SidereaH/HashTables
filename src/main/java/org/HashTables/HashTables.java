package org.HashTables;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;

public class HashTables {
    private String task;
    private String[] stringArray;
    private LinkedHashMap<String, Integer> map;

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
    @Override
    public String toString(){
        switch (task){
            case "1"-> {
                return String.format(
                        """
                        Задание: %s;
                        Массив строк: %s;
                        Хеш-таблица: %s;""",
                        task,
                        Arrays.toString(stringArray),
                        getMapFromStringList(stringArray)
                );
            }
            case "2" -> {
                return String.format(
                        """
                        Задание: %s;
                        Список неотсортированных ключей: %s;
                        Список отсортированных ключей: %s""",
                        task,
                        map.keySet(),
                        Arrays.toString(getSortedKeys(map))



                );
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
}