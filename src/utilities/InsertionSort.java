package utilities;

import comparisons.BaseAreaCompare;
import comparisons.VolumeCompare;
import problemdomain.*;
/**
 * implementation of insertion sort.  Called by the sorting manager and sorts the array.  The method determines what the comparison type is
 * and sorts it accordingly
 * @author Hussein
 *
 */
public class InsertionSort {

	private String comparisonType;
	private VolumeCompare vc;
	private BaseAreaCompare bc;
	/**
	 * Constructor for insertion sort
	 * @param comparisonType comparisontype to sort correctly
	 */
	public InsertionSort(String comparisonType) {
		this.comparisonType = comparisonType;
		if (comparisonType.equalsIgnoreCase("v")) {
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
		for (int i = 1; i < array.length; i++) { //loop through whole array after first element
			for (int j = 0; j < i; j++) { //loop through beginning of array to the first iterator
				if (array[i].compareTo(array[j]) >= 0) { //if out of order, swap them to be in order
					Shape temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	/**
	 * sorts the array by base area
	 * @param array array to sort
	 */
	private void sortByBaseArea(Shape[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (bc.compare(array[i], array[j]) >= 0) {
					Shape temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}
	/**
	 * sorts the array by volume
	 * @param array array to sort
	 */
	private void sortByVolume(Shape[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < i; j++) {
				if (vc.compare(array[i], array[j]) >= 0) {
					Shape temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}

			}
		}
	}
}