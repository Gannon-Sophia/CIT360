/**
 * 
 */
/**
 * @author sophiagannon
 *
 */
package javaCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class arrayList {
	
	public static void main(String[] args) {
		
		List<Double>tempList = new ArrayList<Double>();
		
		tempList.add(83.9);
		tempList.add(57.8);
		tempList.add(60.5);
		tempList.add(35.3);
		tempList.add(45.6);
		
		// Print elements of temperatureList
		System.out.println("Temperature List: " + tempList);
		
		//Get maximum temperature from list
		Double max = Collections.max(tempList);
		System.out.println("Maximun temperature: "+ max);
		
		//Get minimum temperature from list
		Double min = Collections.min(tempList);
		System.out.println("Minimum temperature: "+ min);
		
		//Reverse the list
		Collections.reverse(tempList);
		System.out.println("Reversed List: "+ tempList);
		
		//Copy elements from one list to another
		List<Double>newtempList = new ArrayList<Double>(tempList.size());
		newtempList.add(23.6);
		newtempList.add(10.5);
		newtempList.add(52.3);
		newtempList.add(44.4);
		newtempList.add(37.2);
		System.out.println("New temperature list: "+ newtempList);
		Collections.copy( newtempList, tempList);
		System.out.println("New temperature list after copy: "+  newtempList);
		
		//Replaces all specified value in a list with another.
		Collections.replaceAll(tempList, 60.5, 0.0);
		System.out.println("After replaceAll: "+ tempList);
		
	}

}
