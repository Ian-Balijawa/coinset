package com.Changer;

/** 
 * @author Rein Smedinga, Rijksuniversiteit Groningen
 * @version 1.1 2000-06-03
 * Changer
 * contains algorithm to return the smallest number of coins, given a coinSet
 * and given a total amount. 
 * We do not explain the working of the algorithm. Believe me: it works.
 * 
 */

import java.util.*;
import java.io.*;

public class Changer extends Observable implements Serializable {

  public int[] change(int totalAmount, int[] coinsValue) {
    int numberOfCoins = coinsValue.length;
    int n = totalAmount;
    int[][] a = new int[numberOfCoins + 1][n + 1];
    int[][] b = new int[numberOfCoins + 1][n + 1];
    for (int i = 0; i < numberOfCoins; i++) {
      a[i][0] = 0;
      b[i][0] = 0;
    }
    for (int j = 0; j <= n; j++) {
      a[0][j] = j;
      b[0][j] = 1;
    }
    for (int j = 1; j <= n; j++) {
      for (int i = 1; i < numberOfCoins; i++) {
        if (j < coinsValue[i]) {
          a[i][j] = a[i - 1][j];
          b[i][j] = 0;
        } else if (a[i - 1][j] < a[i][j - coinsValue[i]] + 1) {
          a[i][j] = a[i - 1][j];
          b[i][j] = 0;
        } else {
          a[i][j] = a[i][j - coinsValue[i]] + 1;
          b[i][j] = coinsValue[i];
        }
      }
    }
    int number = a[numberOfCoins - 1][n];
    int[] solution = new int[number];
    int k = n;
    while (k > 0) {
      number--;
      int i = numberOfCoins - 1;
      while (b[i][k] == 0) {
        i--;
      }
      solution[number] = coinsValue[i];
      k = k - coinsValue[i];
    }
    return solution;
  }
}
