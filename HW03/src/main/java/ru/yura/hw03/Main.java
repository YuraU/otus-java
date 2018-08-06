package ru.yura.hw03;

import java.util.*;

public class Main {

    public static void main(String... args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        for (int i = 0; i<=10005; i++) {
            list.add(i);
        }

        List<Integer> linkedList = new LinkedList<Integer>(list);
        list.addAll(linkedList);

        List<Integer> integerList = new MyArrayList<Integer>(list.size());
        for (int i=0;i<list.size();i++) {
            integerList.add(-1);
        }
        Collections.copy(integerList, list);

        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
    }

}
