package apsaraclouder.collection;

import java.util.*;

public class ApsaraClouderCollection {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(2);
//        list.add("guan");
//        list.add("bao");
//        Object[] arrayObj = list.toArray();
//        for (int i = 0; i < arrayObj.length; i++) {
//            System.out.println(arrayObj[i]);
//            System.out.println(arrayObj[i].getClass());
//        }
//
//        String[] arrayStr = list.toArray(new String[0]);  // 使用toArray方法需要传入具体的参数，数组长度为0
//        for (int i = 0; i < arrayStr.length; i++) {
//            System.out.println(arrayStr[i]);
//            System.out.println(arrayStr[i].getClass());
//        }

        // 创建不同类型数组： Integer, Double 和 Character
//        Integer[] intArray = { 1, 2, 3, 4, 5 };
//        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
//        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
//
//        System.out.println("intArray: ");
//        printArray(intArray);
//
//        System.out.println("doubleArray: ");
//        printArray(doubleArray);
//
//        System.out.println("charArray: ");
//        printArray(charArray);


//        iterItem();


        eachMap();
    }

    /*
    * T是泛型，表示可以接受多种数据类型
    * < ? extends T> 表示该通配符所代表的类型是T类型的子类。
    * < ? super T> 表示该通配符所代表的类型是T类型的父类。
    * 通配符是用“?”代替具体的类型参数
    * */
    public static <T> void printArray(T[] array) {
        for (T element: array) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    public static <T> void printList(List<T> array) {
        for (T element: array) {
            System.out.print(element + ", ");
        }
        System.out.println();
    }

    /*
    * 遍历可变元素的方法
    * 1. 不可以在foreach的方法里面进行元素的add和remove操作，这个主要是因为元素的add和remove操作会更新索引
    * 2. 应该使用hashNext进行遍历
    * */
    public static void iterItem() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        List<String> list2 = new ArrayList<>();
        list2.add("1");
        list2.add("2");

        Iterator<String> listIter = list1.iterator();
        while (listIter.hasNext()) {
            String s = (String) listIter.next();
            if ("1".equals(s)) {
                listIter.remove();
            }
        }
        printList(list1);

        for (String s: list2) {
            if ("1".equals(s)) {
                list2.remove(s);
            }
        }
        printList(list2);
    }

    /*
    * 遍历集合使用entrySet遍历，不使用keySet遍历，因为实际上keySet遍历了两次，java8以上的使用Map.forEach方法
    * */
    public static void eachMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 100000; i++) {
            String keyAndValue = getUUID();
            map.put(keyAndValue, keyAndValue);
        }

        System.out.println("keySet start: ");
        Long startTs = System.currentTimeMillis();
        for (String k: map.keySet()) {
            System.out.print("");
        }
        Long endTs = System.currentTimeMillis();
        System.out.println("keySet total time: " + (endTs - startTs));

        System.out.println("entrySet start: ");
        startTs = System.currentTimeMillis();
        Iterator<Map.Entry<String, String>> strMapIter = map.entrySet().iterator();
        while (strMapIter.hasNext()) {
            Map.Entry<String, String> entry = strMapIter.next();
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.print("");
        }
        endTs = System.currentTimeMillis();
        System.out.println("entrySet total time: " + (endTs - startTs));

        System.out.println("forEach start: ");
        startTs = System.currentTimeMillis();
        map.forEach((k, v) -> {
            System.out.print("");
        });
        endTs = System.currentTimeMillis();
        System.out.println("forEach total time: " + (endTs - startTs));
    }

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        return uuidStr.replace("-", "");
    }
}
