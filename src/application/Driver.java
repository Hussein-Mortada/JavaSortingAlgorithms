package application;
/**
 * This is a sorting assignment.  It uses command line to read in user arguments to decide on a sorting algorithm
 * and a file of shape objects to sort.  If the arguments are incorrect it will display a message showing the correct
 * format of how to write the arguments.  If the arguments are correct it will read in the file, instantiate shape
 * objects using reflection, and store them into an array.  It will then call the relevant sorting algorithm and 
 * sort the array in descending order.  It will finally display every 1000th element in the array to show it is sorted
 * and then display the timing of the sort.
 * @author Hussein
 *
 */
public class Driver {

	public static void main(String[] args) {
				
		new SortingManager(args);

	}

}
