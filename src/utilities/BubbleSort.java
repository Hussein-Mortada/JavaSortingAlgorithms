package utilities;

import comparisons.BaseAreaCompare;
import comparisons.VolumeCompare;
import problemdomain.*;
/**
 * implementation of bubble sort.  Called by the sorting manager and sorts the array.  The method determines what the comparison type is
 * and sorts it accordingly
 * @author Hussein
 *
 */
public class BubbleSort {

	private String comparisonType;
	private VolumeCompare vc;
	private BaseAreaCompare bc;
	/**
	 * Constructor for BubbleSort
	 * @param comparisonType comparisontype to sort correctly
	 */
	public BubbleSort(String comparisonType) {
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
		
		for(int i=0;i<array.length;i++) { //loop through array
			for(int j=i+1;j<array.length;j++) { //element after current iterator
				if(array[i].compareTo(array[j])<=0) { //checks if out of order then swaps
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
		
		
		for(int i=0;i<array.length;i++) {//loop through array
			for(int j=i+1;j<array.length;j++) {//element after current iterator
				if(bc.compare(array[i], array[j])<=0) { //checks if out of order then swaps
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
			
			for(int i=0;i<array.length;i++) {
				for(int j=i+1;j<array.length;j++) {
					if(vc.compare(array[i], array[j])<=0) {
						Shape temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
	}
}