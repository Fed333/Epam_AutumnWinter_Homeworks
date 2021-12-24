package com.company;

import com.company.collection.NotRemovableArrayList;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        task1();
        askNextMove();
        task2();
    }



    private static void askNextMove(){
        System.out.println("Продовжити (Enter): ");
        new Scanner(System.in).nextLine();
    }

    private static void task1(){
        List<Integer> array = new ArrayList<>(Arrays.asList(4,5,-6,4,5,3,4,2,4,5,7));
//        array.add(0);   //<-- successfully adding

        System.out.println("Масив: " + array);

        TreeMap<Integer, Integer> entryMap = new TreeMap<>();

        for (Integer el:array) {
            entryMap.put(el, entryMap.getOrDefault(el, 0)+1);
        }
        System.out.println("Кількість повторень кожного елемента: ");
        for (Map.Entry<Integer, Integer> en:entryMap.entrySet()) {
            System.out.printf("%2d - %-4d\n", en.getKey(), en.getValue());
        }

    }


    private static void task2() {
        NotRemovableArrayList<Integer> arrayList = new NotRemovableArrayList<>();
        for (int i = 1; i <= 10; i++) {
            arrayList.add(i);
        }

        arrayList.add(arrayList.size()/2, -2);
        arrayList.add(arrayList.size()/3, -3);
        arrayList.add(arrayList.size()/4, -4);
        arrayList.add(arrayList.size()/5, -5);

        System.out.println("Before: " + arrayList);


        System.out.println("Attempt to remove an element");

        try {
            arrayList.remove(0);
        }
        catch (UnsupportedOperationException e){
            System.out.println(e.getClass().getSimpleName() + " was caught");
            System.out.println("message: "+e.getMessage());
        }
        System.out.println("After: " + arrayList);

    }
}
