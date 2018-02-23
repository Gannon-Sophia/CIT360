/**
 * 
 */
/**
 * @author sophiagannon
 *
 */

package javaCollection;

import java.util.TreeMap;

public class treeMapItemSearch {
	public static void main(String a[]){
        TreeMap<String, String> hm = new TreeMap<String, String>();
        //add key-value pair to TreeMap
        hm.put("First Fruit ", " Guiava");
        hm.put("Second Fruit ", " Watermelon");
        hm.put("Third Fruit ", " Nectarine");
        System.out.println(hm);
        if(hm.containsValue(" Watermelon")){
            System.out.println("The TreeMap contains value Watermelon");
        } else {
            System.out.println("The TreeMap doesn't contains value Watermelon");
        }
        if(hm.containsValue("First Fruit")){
            System.out.println("The TreeMap contains value First Fruit");
        } else {
            System.out.println("The TreeMap doesn't contains value First Fruit");
        }
    }
}

