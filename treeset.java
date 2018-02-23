/**
 * 
 */
/**
 * @author sophiagannon
 *
 */

package javaCollection;

import java.util.TreeSet;

public class TreeSetCode {
     public static void main(String args[]) {
         // TreeSet of String Type
         TreeSet<String> treeset = new TreeSet<String>();

         // Adding elements to TreeSet<String>
         treeset.add("I'm");
         treeset.add("Learning");
         treeset.add("To");
         treeset.add("Love");
         treeset.add("Software");
         treeset.add("Development");

         //Displaying TreeSet
         System.out.println(treeset);

         // TreeSet of Integer Type
         TreeSet<Integer> treeset2 = new TreeSet<Integer>();

         // Adding elements to TreeSet<Integer>
         treeset2.add(50);
         treeset2.add(7);
         treeset2.add(100);
         treeset2.add(0);
         treeset2.add(5);
         treeset2.add(150);
         System.out.println(treeset2);
    }
 }
