package com.simpleCoinSetTest;

import com.Changer.*;
import com.Console.*;
import com.SimpleCoinSet.*;
import java.util.*;

public class simpleCoinSetTest extends Object {
	public static void main (String [] argv) {
		String answer  = Console.readString("random test, self test, intersection, or union? [r/s/i/u] (s): ");
		if (answer.equals("r")) t_random();
		else if (answer.equals("i")) t_intersect();
		else if (answer.equals("u")) t_union();
		else t_self();
	}

	public static void t_random () {
		simpleCoinSet coins = get_random();
		System.out.println("Coin Set: "+ coins.toString() +"\n");
		Random coinz  = new Random ();
		Changer c = new Changer();
		for (int i = 0; i < 10; i++) {
			int val = coinz.nextInt(15000-1)+1;
			printRow(val, c.change(val, coins.toArray()));
		}
	}

	public static simpleCoinSet get_random() {
		simpleCoinSet coins = new simpleCoinSet(10);
		Random coinz  = new Random ();

		for (int i = 0; i < 10; i++) {
			int val = coinz.nextInt(1000 - 1)+1;
			coins.add(val);
			if (i % 4 == 0) { // test remove()
				System.out.print("Replacing "+ val);
				coins.remove(val); val = coinz.nextInt(1000-1)+1; coins.add(val);
				System.out.println(" with "+ val);
			}
		}
		return coins;
	}

	public static void t_intersect() {
		simpleCoinSet coins = get_random();
		coins = coins.intersect(get_self(10));

		do_self(coins);
	}

	public static void t_union() {
		simpleCoinSet coins = get_random();
		coins = coins.union(get_self(10));

		do_self(coins);
	}

	public static void t_self () {
		simpleCoinSet coins = get_self(10);
		do_self(coins);
	}

	public static simpleCoinSet get_self(int size) {
		simpleCoinSet coins = new simpleCoinSet(size);
		System.out.println("Enter coin values, stop by entering a 0");
		int val = Console.readInt("value:");
		while (val != 0) {
			coins.add(val);
			val = Console.readInt("value:");
		}
		return coins;
	}

	public static void do_self(simpleCoinSet coins) {
		System.out.println("\nCoin Set: "+ coins.toString());
		System.out.println("Enter amounts, stop by entering a 0");
		int val = Console.readInt("amount:");
		Changer c = new Changer();
		while (val != 0) {
			printRow(val, c.change(val, coins.toArray()));
			val = Console.readInt("amount:");
		}
	}

	public static void printForm(String str, int i) {
		System.out.print(str);
		for (int j = str.length(); j < i; j++) System.out.print(" ");
	}

	public static void printRow(int val, int[] coins) {
		String str = String.valueOf(val);
		printForm(str, 5); System.out.print("=> ");
		str = String.valueOf(coins.length);
		printForm("("+str+")", 5); System.out.print(": ");
		System.out.println(Arrays.toString(coins));
	}
}
