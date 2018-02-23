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

public class arrayList2 {

		public static void main(String[] args) {
			
			List<Double>tempList = new ArrayList<Double>();
			
			tempList.add(80.5);
			tempList.add(64.0);
			tempList.add(45.5);
			tempList.add(28.4);
			tempList.add(32.2);
			
			// Print elements of tempList
			System.out.println("Temperature List:" + tempList);
			
			// Sorting List in ascending order
			Collections.sort(tempList);
			System.out.println("Sorted List: " + tempList);
			
			// Searching a temperature from list
			int searchIndex = Collections.binarySearch(tempList, 45.5);
			if(searchIndex >=0){
				System.out.println("Was the Temperature found? " + "Yes, it was.");
			}
			else{
				System.out.println("Was the Temperature found? " + "No, it wasn't.");
			}
			
			//Shuffles the list
			Collections.shuffle(tempList);
			System.out.println("Shuffled List: " + tempList);
			
			//replace temperatureList.
			Collections.fill(tempList, 0.0);
			System.out.println("Replaced List: " + tempList);
				
		}
	}


