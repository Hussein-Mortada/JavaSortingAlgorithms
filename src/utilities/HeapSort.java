package utilities;

import comparisons.BaseAreaCompare;
import comparisons.VolumeCompare;
import problemdomain.*;
/**
 * implementation of heap sort.  Called by the sorting manager and sorts the array.  The method determines what the comparison type is
 * and sorts it accordingly.  Please see the mySort.txt in the root of the directory to see exact psuedocode
 * @author Hussein
 *
 */
public class HeapSort {

	private String comparisonType;
	private VolumeCompare vc;
	private BaseAreaCompare bc;
	/**
	 * Constructor for Heap Sort
	 * @param comparisonType comparisontype to sort correctly
	 */
	public HeapSort(String comparisonType) {
		this.comparisonType = comparisonType;
		if (comparisonType.equalsIgnoreCase("v")) {
			vc = new VolumeCompare();
		} else if (comparisonType.equalsIgnoreCase("b")) {
			bc = new BaseAreaCompare();
		}
	}
/**
 * calls the heap sort
 * @param array array to sort
 */
	public void sort(Shape[] array) {
			heapSort(array);

	}
	/**
	 * heap sort method.  Builds max heap and then extracts the last element from the tree.  Calls heapify on the new  tree 
	 * @param array array to sort
	 */
	public void heapSort(Shape array[])
    {
        int n = array.length;
          for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
  
        for (int i = n - 1; i >= 0; i--) {
            Shape temp = array[0];
            array[0] = array[i];
            array[i] = temp;
  
            heapify(array, i, 0);
        }
    }
/**
 * builds the heap.  takes the root as the largest element.  reads through the tree and swaps elements if they are found out of order
 * calls heapify again to build the complete heap
 * @param array array to sort
 * @param n array size
 * @param i root of the tree
 */
	public void heapify(Shape array[], int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
  
        if (comparisonType.equalsIgnoreCase("v")) {
        	if (l < n && vc.compare(array[l],array[largest]) <=0 )
                largest = l;
      
            if (r < n && vc.compare(array[r], array[largest]) <=0 )
                largest = r;
      
            if (largest != i) {
                Shape swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;
      
                heapify(array, n, largest);
            }
        }
		else if(comparisonType.equalsIgnoreCase("b")) {
			if (l < n && bc.compare(array[l],array[largest]) <=0 )
                largest = l;
      
            if (r < n && bc.compare(array[r], array[largest]) <=0 )
                largest = r;
      
            if (largest != i) {
                Shape swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;
      
                heapify(array, n, largest);
            }
		}
		else {
			if (l < n && array[l].compareTo(array[largest]) <=0 )
                largest = l;
      
            if (r < n && array[r].compareTo(array[largest]) <=0 )
                largest = r;
      
            if (largest != i) {
                Shape swap = array[i];
                array[i] = array[largest];
                array[largest] = swap;
      
                heapify(array, n, largest);
            }
		}
        
        
    }
}
