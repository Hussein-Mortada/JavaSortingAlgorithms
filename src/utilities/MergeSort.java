package utilities;

import comparisons.BaseAreaCompare;
import comparisons.VolumeCompare;
import problemdomain.*;
/**
 * implementation of merge sort.  Called by the sorting manager and sorts the array.  The method determines what the comparison type is
 * and sorts it accordingly
 * @author Hussein
 *
 */
public class MergeSort {

	private String comparisonType;
	private VolumeCompare vc;
	private BaseAreaCompare bc;
	/**
	 * Constructor for merge sort
	 * @param comparisonType comparisontype to sort correctly
	 */
	public MergeSort(String comparisonType) {
		this.comparisonType = comparisonType;
		if (comparisonType.equalsIgnoreCase("v")) {
			vc = new VolumeCompare();
		} else if (comparisonType.equalsIgnoreCase("b")) {
			bc = new BaseAreaCompare();
		}
	}
/**
 * calls the merge sort method
 * @param array array to sort
 */
	public void sort(Shape[] array) {
			mergeSort(array);

	}
	/**
	 * Calls the merge sort method
	 * @param array array to sort
	 */
	private void mergeSort(Shape[] array) {
		int arraySize=array.length;
		if(arraySize<2) { //if array is empty or size is 1 it is sorted already
			return;
		}
		int midpoint=array.length/2;
		Shape[] arrayleft=new Shape[midpoint];
		Shape[] arrayright=new Shape[arraySize-midpoint];
		
		for(int i=0;i<midpoint;i++) { //fills left array
			arrayleft[i]=array[i];
		}
		for(int i=midpoint;i<arraySize;i++) { //fills right array
			arrayright[i-midpoint]=array[i]; 
		}
		
		sort(arrayleft); //recursively calls sort on each half
		sort(arrayright);
		
		if (comparisonType.equalsIgnoreCase("v"))
			mergeVolume(array,arrayleft,arrayright);
		else if(comparisonType.equalsIgnoreCase("b")) 
			mergeBaseArea(array,arrayleft,arrayright);
		else
			mergeHeight(array,arrayleft,arrayright);
		
	}
/**
 * Merges the split arrays according to height
 * @param array array to merge
 * @param arrayleft left part of the array
 * @param arrayright right side of the array
 */
	private void mergeHeight(Shape[] array, Shape[] arrayleft, Shape[] arrayright) {
		int leftSize=arrayleft.length;
		int rightSize=arrayright.length;
		int leftIterator=0,rightIterator=0,arrayIterator=0;
		while(leftIterator<leftSize && rightIterator<rightSize) {
			if(arrayleft[leftIterator].compareTo(arrayright[rightIterator])>=0) { // uses comparator to see which is bigger to put in the main array
				array[arrayIterator]=arrayleft[leftIterator];
				leftIterator++; //if the left was bigger, move the left iterator up one
			}
			else {//if the right was bigger, move the right iterator up one and insert the element into main array
				array[arrayIterator]=arrayright[rightIterator];
				rightIterator++;
			}
			arrayIterator++;
		}
		while(leftIterator<leftSize) { //for the last elements that has not been merged, merge it into the main array
			array[arrayIterator]=arrayleft[leftIterator];
			arrayIterator++;
			leftIterator++;
		}
		while(rightIterator<rightSize) {//for the last elements that has not been merged, merge it into the main array
			array[arrayIterator]=arrayright[rightIterator];
			arrayIterator++;
			rightIterator++;
		}
		
	}
	/**
	 * Merges the split arrays according to base area
	 * @param array array to merge
	 * @param arrayleft left part of the array
	 * @param arrayright right side of the array
	 */
	private void mergeBaseArea(Shape[] array, Shape[] arrayleft, Shape[] arrayright) {
		int leftSize=arrayleft.length;
		int rightSize=arrayright.length;
		int leftIterator=0,rightIterator=0,arrayIterator=0;
		while(leftIterator<leftSize && rightIterator<rightSize) {
			if(bc.compare(arrayleft[leftIterator], arrayright[rightIterator])>=0) {
				array[arrayIterator]=arrayleft[leftIterator];
				leftIterator++;
			}
			else {
				array[arrayIterator]=arrayright[rightIterator];
				rightIterator++;
			}
			arrayIterator++;
		}
		while(leftIterator<leftSize) {
			array[arrayIterator]=arrayleft[leftIterator];
			arrayIterator++;
			leftIterator++;
		}
		while(rightIterator<rightSize) {
			array[arrayIterator]=arrayright[rightIterator];
			arrayIterator++;
			rightIterator++;
		}
	}
	/**
	 * Merges the split arrays according to volume
	 * @param array array to merge
	 * @param arrayleft left part of the array
	 * @param arrayright right side of the array
	 */
	private void mergeVolume(Shape[] array, Shape[] arrayleft, Shape[] arrayright) {
		int leftSize=arrayleft.length;
		int rightSize=arrayright.length;
		int leftIterator=0,rightIterator=0,arrayIterator=0;
		while(leftIterator<leftSize && rightIterator<rightSize) {
			if(vc.compare(arrayleft[leftIterator], arrayright[rightIterator])>=0) {
				array[arrayIterator]=arrayleft[leftIterator];
				leftIterator++;
			}
			else {
				array[arrayIterator]=arrayright[rightIterator];
				rightIterator++;
			}
			arrayIterator++;
		}
		while(leftIterator<leftSize) {
			array[arrayIterator]=arrayleft[leftIterator];
			arrayIterator++;
			leftIterator++;
		}
		while(rightIterator<rightSize) {
			array[arrayIterator]=arrayright[rightIterator];
			arrayIterator++;
			rightIterator++;
		}
		
	}
}