package utilities;

import comparisons.*;
import problemdomain.*;
/**
 * implementation of selection sort.  Called by the sorting manager and sorts the array.  The method determines what the comparison type is
 * and sorts it accordingly
 * @author Hussein
 *
 */
public class SelectionSort {

	private String comparisonType;
	private VolumeCompare vc;
	private BaseAreaCompare bc;
	/**
	 * Constructor for quick sort
	 * @param comparisonType comparisontype to sort correctly
	 */
	public SelectionSort(String comparisonType) {
		this.comparisonType = comparisonType;
		if (comparisonType.equalsIgnoreCase("v")) { // creates volume or base area compare objects
			vc = new VolumeCompare();
		} else if (comparisonType.equalsIgnoreCase("b")) {
			bc = new BaseAreaCompare();
		}
	}
	/**
	 * Calls the sorting method according to the comparison type
	 * @param array array to sort
	 */
	public void sort(Shape[] array) {
		if (comparisonType.equalsIgnoreCase("v"))
			sortByVolume(array);
		else if(comparisonType.equalsIgnoreCase("b")) 
			sortByBaseArea(array);	
		else
			sortByHeight(array);
	}
	/**
	 * sorts the array by height
	 * @param array array to sort
	 */
	private void sortByHeight(Shape[] array) {
		for (int i = 0; i < array.length - 1; i++) { //loops through whole array
			int maxElementIndex = i;  //max element starts at the iterator
			for (int j = i + 1; j < array.length; j++) {  //looks for max element after the iterator
				if (array[maxElementIndex].compareTo(array[j]) <= 0) {
					maxElementIndex = j;
				}

			}

			if (maxElementIndex != i) { //if the iterator was not the max element, swap the found one with the iterator
				Shape temp = array[i];
				array[i] = array[maxElementIndex];
				array[maxElementIndex] = temp;
			}
		}
		
	}
	/**
	 * sorts the array by base area
	 * @param array array to sort
	 */
	private void sortByBaseArea(Shape[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int maxElementIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (bc.compare(array[maxElementIndex], array[j]) <= 0) { 
					maxElementIndex = j;
				}

			}

			if (maxElementIndex != i) { 
				Shape temp = array[i];
				array[i] = array[maxElementIndex];
				array[maxElementIndex] = temp;
			}
		}
		
	}
	/**
	 * sorts the array by volume
	 * @param array array to sort
	 */
	private void sortByVolume(Shape[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int maxElementIndex = i; 
			for (int j = i + 1; j < array.length; j++) { 
				if (vc.compare(array[maxElementIndex], array[j]) <= 0) { 
					maxElementIndex = j;
				}

			}

			if (maxElementIndex != i) {
				Shape temp = array[i];
				array[i] = array[maxElementIndex];
				array[maxElementIndex] = temp;
			}
		}		
	}
}
