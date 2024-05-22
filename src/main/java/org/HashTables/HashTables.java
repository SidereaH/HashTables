package org.HashTables;
import java.util.*;
public class HashTables {
    private final String task;
    private String[] stringArray;
    private LinkedHashMap<String, Integer> mapSI;
    private LinkedHashMap<String, Integer> sMapSI;
    private String palindrom;
    private List<LinkedHashMap<String,Integer>> arraysOfMaps;
    private LinkedHashMap<String, Integer> mergedArrMap = new LinkedHashMap<>();
    private ArrayList<Integer> intList;
    private LinkedHashMap<Integer, Integer> mapII;
    private LinkedHashMap<Integer, Integer> sMapII;
    public HashTables(String task){
        this.task = task;
    }
    public HashTables getHashFromStrings(String[] arr){
        this.stringArray = arr;
        return this;
    }
    public HashTables getSortedKeySet(LinkedHashMap<String, Integer> map){
        this.mapSI = map;
        return this;
    }
    public HashTables isPalindrom(String palindrom){
        this.palindrom = palindrom;
        return this;
    }
    public HashTables mergeTables(LinkedHashMap<String, Integer> map1, LinkedHashMap<String,Integer> map2){
        this.mapSI = map1;
        this.sMapSI = map2;
        return this;
    }
    public HashTables mergeTables(List<LinkedHashMap<String,Integer>> arrayOfMaps){
        this.arraysOfMaps = arrayOfMaps;
        return this;
    }
    public HashTables compareTables(LinkedHashMap<String , Integer> map1, LinkedHashMap<String , Integer> map2){
        this.mapSI = map1;
        this.sMapSI = map2;
        return this;
    }
    public HashTables createHashMapFromIntArr(ArrayList<Integer> intList){
        this.intList = intList;
        return this;
    }
    public HashTables removeEvenNums(LinkedHashMap<Integer, Integer> map){
        this.mapII = map;
        return this;
    }
    public HashTables compareIntTablesWithExistingKeys(LinkedHashMap<Integer, Integer> map1, LinkedHashMap<Integer, Integer> map2){
        this.mapII = map1;
        this.sMapII = map2;
        return this;
    }
    @Override
    public String toString(){
        switch (task){
            case "1"-> {
                return String.format(
                        """
                        Задание: %s,
                        Список строк: %s,
                        Хеш-таблица: %s.
                        """,
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
                        Список отсортированных ключей: %s.
                        """,
                        task,
                        mapSI.keySet(),
                        Arrays.toString(getSortedKeys(mapSI))
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
                        mergeTable(mapSI, sMapSI));
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
            case "6" ->{
                return String.format("""
                        Задание: %s,
                        Совпавшие ключи: %s,
                        Совпавшие значения: %s,
                        Совпавшие поля ключ : значение: %s,
                        """,
                        task,
                        keysCompare(mapSI, sMapSI),
                        valueCompare(mapSI, sMapSI),
                        keysValueCompare(mapSI, sMapSI));
            }
            case "7" ->{
                return String.format("""
                        Задание: %s,
                        Массив чисел: %s,
                        Хеш-таблица: %s.
                        """,
                        task,
                        intList.toString(),
                        intAbsMap(intList));
            }
            case "8" ->{
                return  String.format("""
                        Задание: %s,
                        ishodnaya хеш-таблица: %s,
                        removed четные ключи: %s.
                       
                        """,
                        task,
                        mapII.toString(),
                        removeEvenMap(mapII));
            }
            case "9" -> {
                return String.format("""
                        Задание: %s,
                        Первая хеш таблица: %s,
                        Вторая хеш-таблица: %s,
                        Оставлены совпадения ключей, значения перемножены: %s.
                        """,
                        task,
                        mapII,
                        sMapII,
                        compareIntHash(mapII,sMapII));
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
    public LinkedHashMap<Integer, Integer> compareIntHash(LinkedHashMap<Integer,Integer> map1,LinkedHashMap<Integer,Integer> map2){
        LinkedHashMap<Integer, Integer> comparedMap = new LinkedHashMap<>();
        for(Map.Entry<Integer, Integer> entry : map1.entrySet()){
            for (Map.Entry<Integer, Integer> entry2 : map2.entrySet()){

                if (Objects.equals(entry.getKey(), entry2.getKey())){
                    if (Objects.equals(entry.getValue(), entry2.getValue())){
                        comparedMap.put(entry2.getKey(), entry2.getValue()*entry.getValue());
                    }
                }
            }
        }
        return comparedMap;
    }
    public LinkedHashMap<Integer, Integer> removeEvenMap(LinkedHashMap<Integer, Integer> map) {
        LinkedHashMap<Integer, Integer> removed;
        removed = (LinkedHashMap<Integer, Integer>) map.clone();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getKey()%2 ==0){
                removed.remove(entry.getKey());
            }
        }
        return  removed;
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

        int count = 0;
        for (String s : array) {
            if (Objects.equals(word, s)) {
                count++;
            }
        }
        return count;
    }
    public LinkedHashMap<Integer, Integer> intAbsMap (ArrayList<Integer> list){
        LinkedHashMap<Integer, Integer> absMap = new LinkedHashMap<>();
        for (int i =0; i<list.size(); i++){
            absMap.put(list.get(i), (list.get(i) * list.get(i)));
        }
        return absMap;
    }
    public LinkedHashMap<String, Integer> keysValueCompare (LinkedHashMap<String, Integer> map1, LinkedHashMap<String, Integer> map2){
        LinkedHashMap<String, Integer> keys = new LinkedHashMap<>();
        //ArrayList<String> values = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            for (Map.Entry<String, Integer> entry2 : map2.entrySet()){

                if (Objects.equals(entry.getKey(), entry2.getKey())){
                    if (Objects.equals(entry.getValue(), entry2.getValue())){
                        keys.put(entry2.getKey(), entry2.getValue());
                    }
                }
            }
        }
        return keys;
    }
    public ArrayList<String> keysCompare (LinkedHashMap<String, Integer> map1, LinkedHashMap<String, Integer> map2){
        ArrayList<String> keys = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            for (Map.Entry<String, Integer> entry2 : map2.entrySet()){
                if (Objects.equals(entry.getKey(), entry2.getKey())){
                    keys.add(entry2.getKey());
                }
            }
        }
        return keys;
    }
    public ArrayList<String> valueCompare (LinkedHashMap<String, Integer> map1, LinkedHashMap<String, Integer> map2){
        ArrayList<String> values = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : map1.entrySet()){
            for (Map.Entry<String, Integer> entry2 : map2.entrySet()){
                if (Objects.equals(entry.getValue(), entry2.getValue())){
                        values.add(String.valueOf(entry2.getValue()));
                }
            }
        }
        return values;
    }
    public String[] getSortedKeys(LinkedHashMap<String,Integer> map){
        String[] array = getIntArrayFromHashTable(map);
        quickSortString(array, 0, array.length-1);
        return array;
    }
    private String[] getIntArrayFromHashTable(LinkedHashMap<String, Integer> map){
        return map.keySet().toArray(new String[0]);
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

                Integer value = mapSI.get(entry.getKey());

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
    }

}