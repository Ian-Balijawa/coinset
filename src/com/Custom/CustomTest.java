package com.Custom;

import java.util.Arrays;

import com.SimpleCoinSet.simpleCoinSet;

public class CustomTest {

    public static void main(String [] args) {
       simpleCoinSet set1 = new simpleCoinSet();
        for (int i = 1; i <= 50; i++) {
           set1.add((int)(1 + Math.random() * 100));
        }
        
        System.out.println("set1 " + set1.getCount());
                
        simpleCoinSet set2 = new simpleCoinSet(5);
        for (int i = 1; i <= 25; i++) {
            set2.add((int)(1 + Math.random() * 100));
        }

        System.out.println("set2 " + set2.getCount());

        System.out.println("set1 "+set1.toString());
        System.out.println("set2 "+set2.toString());
        System.out.println();

        simpleCoinSet intersectingSet = set1.intersect(set2);
        simpleCoinSet unionSet = set1.union(set2);

        System.out.println("Intersection " +Arrays.toString(intersectingSet.toArray()));
        System.out.println("union " + Arrays.toString(unionSet.toArray()));

        int[] arr = new int[4];
        arr[1] = 32;
        arr[0] = 32;
        System.out.println(arr.length);
    }
}
