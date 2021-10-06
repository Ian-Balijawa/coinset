
package com.CoinSetInterface;

public interface simpleCoinSetInt {
   // Test whether the set is empty
   public boolean isEmpty();

   // Add a @value to the set
   public void add(int value);

   // Remove a @value from the set
   public void remove(int value);

   // Return the number of elements in the set
   public int getCount();

   // Return a representation of this set as an array
   public int[] toArray();

   /**
    * Return a string representation of the set The empty set is represented as {}
    */
   public String toString();
}
