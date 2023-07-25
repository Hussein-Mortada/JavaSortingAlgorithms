package utilities;

import java.util.Random;

import comparisons.BaseAreaCompare;
import comparisons.VolumeCompare;
import problemdomain.*;
/**
 * implementation of quick sort.  Called by the sorting manager and sorts the array.  The method determines what the comparison type is
 * and sorts it accordingly
 * @author Hussein
 *
 */
public class QuickSort {

	private String comparisonType;
	private VolumeCompare vc;
	private BaseAreaCompare bc;
	/**
	 * Constructor for quick sort
	 * @param comparisonType comparisontype to sort correctly
	 */
	public QuickSort(String comparisonType) {
		this.comparisonType = comparisonType;
		if (comparisonType.equalsIgnoreCase("v")) {
			vc = new VolumeCompare();
		} else if (comparisonType.equalsIgnoreCase("b")) {
			bc = new BaseAreaCompare();
		}

	}
	/**
	 * calls the quick sort method
	 * @param array array to sort
	 */
	public void sort(Shape[] array) {
		sort(array, 0, array.length - 1);

	}
/**
 * Takes an array and makes a pivot.  It will use the pivot and swap it to the end of the array. It will then partition the array
 * according to the pivot and then recursively call itself to do the same with the left half and the right half of the array
 * @param array array to sort
 * @param low lowest element of the array
 * @param high highest element of the array
 */
	private void sort(Shape[] array, int low, int high) {

		if (low >= high) { //validates the array first 
			return;
		}
		int pivotIndex=new Random().nextInt(high-low)+low; //random pivot index
		Shape pivot = array[pivotIndex]; //pivot to use
		swap(array, pivotIndex, high); //puts the pivot to the end of the array 

		int leftP = partition(array, low, high, pivot);

		sort(array, low, leftP - 1); //recurively calls quicksort on both halves
		sort(array, leftP + 1, high);

	}
/**
 * partition the array from the sort.  This will take the pivot and make the right and left half of the arrays swap them to be on the 
 * left side or the right side of the array.  It will then return the left pointer to the quick sort to use to make 2 separate arrays 
 * and recursively call
 * @param array array to sort
 * @param low lowest element of the array
 * @param high highest element of the array
 * @param pivot pivot to use
 * @return leftP returns the leftP to split the arrays into right and left sides 
 */
	private int partition(Shape[] array, int low, int high, Shape pivot) {
		int leftP = low; //left of the pivot starting at the low
		int rightP = high; //right of pivot starting at high

		while (leftP < rightP) { //loops until all elements sorted to left and right of pivot correctly
			if (comparisonType.equalsIgnoreCase("v")) { //volume  compare
				while (vc.compare(array[leftP], pivot) >= 0 && leftP < rightP) { //loops to find an element where smaller than pivot
																					
					leftP++;
				}
				while (vc.compare(array[rightP], pivot) <= 0 && leftP < rightP) { // move right pointer until larger
																					// value found
					rightP--;
				}
			} else if (comparisonType.equalsIgnoreCase("b")) { //base area compare
				while (bc.compare(array[leftP], pivot) >= 0 && leftP < rightP) {
					leftP++;
				}
				while (bc.compare(array[rightP], pivot) <= 0 && leftP < rightP) {
					rightP--;
				}
			} else { //height compare
				while (array[leftP].compareTo(pivot) >= 0 && leftP < rightP) {
					leftP++;
				}
				while (array[rightP].compareTo(pivot) <= 0 && leftP < rightP) {
					rightP--;
				}
			}

			swap(array, leftP, rightP); //swaps the left and right pivot
		}
		swap(array, leftP, high); //swaps left pivot and the high point
		return leftP; //returns the left pivot index
	}
/**
 * swaps elements
 * @param array array to use and swap elements in
 * @param index1 first index to swap
 * @param index2 second index to swap
 */
	private void swap(Shape[] array, int index1, int index2) {
		Shape temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
