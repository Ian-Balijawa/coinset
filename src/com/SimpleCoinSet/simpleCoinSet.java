package com.SimpleCoinSet;

import com.CoinSetInterface.simpleCoinSetInt;
import java.util.*;
import java.util.stream.*;

public class simpleCoinSet implements simpleCoinSetInt {

    //This should always be the initial capacity considering a ugandan case with 5 coins 50, 100, 200, 500, 1000
    private int numberOfCoins = 0;
    private List<Integer> coins;

    //We enforce the set of coins to always have an initial capacity of five when no capacity is specified
    public simpleCoinSet() {
        this(5);
    }

    public simpleCoinSet(int Capacity) {
        coins = new ArrayList<>(Capacity);
    }

    public boolean isEmpty() {
        return this.numberOfCoins == 0;
    }

    public void add(int value) {
        if (!coins.contains(value)) {
            coins.add(value);
            numberOfCoins++;
        }
    }

    public int getCount() {
        return this.numberOfCoins;
    }

    public int[] toArray() {
        int[] coinArr = new int[coins.size()];
        for (int i = 0; i < coinArr.length; i++) {
            coinArr[i] = coins.get(i);
        }
        return coinArr;
    }

    public void remove(int value) {
        if (coins.contains(value)) {
            coins.remove(coins.indexOf(value));
            numberOfCoins--;
        }
    }

    public String toString() {
        StringBuilder msg = new StringBuilder();
        for (Integer coin : coins) {
            msg.append(" ").append(coin);
        }
        return msg.toString();
    }

    /**
     * @param other assumes distinct coins e.g 50,500,200,100,1000 without any repeating coins
     * @return An object of type simpleCoinSet having only the intersection coins between
     * two coin objects of type simpleCoinSet
     * @see simpleCoinSet#add(int) simpleCoinSet object always has distict coins
     * @return intersection of two coin sets each having distinct/unique elements as a result of the 
     * @see simpleCoinSet#add(int) method in the class that makes this possible
     * When you run a test on this method against the main in simpleCoinTest class, the following is encoutered;
     * @see simpleCoinSetTest#t_intersect() this method produces a set of random coin values that must be used in comparision
     * against the manually console read coin values. Chances are that when a user inputs a number of values,
     * he/she may get an empty list of intersecting elements,meaning no intersecting elements. This happens almost all of the time because you don't know
     * what values are in the other set. In addition these keep changing every time you run the program.
     */
        public simpleCoinSet intersect(simpleCoinSet other) {
        List<Integer> commons = this.coins.stream().filter(other.coins::contains).collect(Collectors.toList());
        simpleCoinSet intersection = new simpleCoinSet(Math.min(this.coins.size(), other.coins.size()));
        intersection.coins = commons;
        
        return intersection;
    }

    /**
     * @param other assumes distinct coins e.g 50,500,200,100,1000 without any repeating coins
     * @return An object of type simpleCoinSet having only the union coins between
     * two coin objects of type simpleCoinSet
     * @see simpleCoinSet#add(int) simpleCoinSet object always has distict coins
     * @return union of two coin sets each having all elements of the bigger coin Set plus the 
     * intersection @see simpleCoinSet#intersect(simpleCoinSet)
     * @see simpleCoinSet#add(int) method in the class that makes this possible
     */
    public simpleCoinSet union(simpleCoinSet other) {
        Set<Integer> unionSet = new HashSet<Integer>();
        unionSet.addAll(this.coins);
        unionSet.addAll(other.coins);
        simpleCoinSet union = new simpleCoinSet(unionSet.size());

        Object [] setArr = unionSet.toArray();
        for(int i = 0;i < setArr.length;i++) {
            union.coins.add((Integer)setArr[i]);
        }
        return union;
    }
}