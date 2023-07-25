package application;
import problemdomain.*;
import utilities.*;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
/**
 * Sorting manager.  Takes in command line arguments and then follows the steps of parsing the args, reading the file and
 * filling the array, calling the sorting algorithm, then printing the sorted array and the timing.
 * @author Hussein
 *
 */
public class SortingManager{

	private  String fileLocation;
	private  String sortingAlgorithm;
	private  String comparisonType;
	private Shape[] shapes;
	private int fileReadTime;
	/**
	 * Constructor.  Reads in args then calls the parseargs, fillarray, callsort methods in order.
	 * @param args Command line arguments
	 */
	public SortingManager(String[] args) {
		parseArgs(args);
		fillArray();
		callSort(sortingAlgorithm,comparisonType);
	}
	/**
	 * Parses the arguments and stores them in global variables to be used in other methods.
	 * Displays invalid messages if the arguments are written incorrectly.
	 * @param args Command line arguments
	 */
	public void parseArgs(String[] args)
    {
		for (int i = 0; i < args.length; i++) { //loops through arguments and assigns the values correctly
            if (args[i].substring(0,2).equalsIgnoreCase("-f")) {
            	fileLocation = args[i].substring(2);
            } else if (args[i].substring(0,2).equalsIgnoreCase("-t")) {
            	comparisonType = args[i].substring(2);
            } else if (args[i].substring(0,2).equalsIgnoreCase("-s")) {
            	sortingAlgorithm = args[i].substring(2);
            }
        }

        if (fileLocation==null || fileLocation.equals("") || sortingAlgorithm==null||  sortingAlgorithm.equals("")||
        		comparisonType==null|| comparisonType.equals("")) { //checks if anything was empty and errors
            System.out.println("Error: Missing command line arguments. Please use the format: ");
            System.out.println("java -jar sort.jar -f <fileName> -t <compareType> -s <sortType>");
            System.exit(0);
        }

        File file = new File(fileLocation);
        if (!file.exists()) { //checks if file exists
            System.out.println("Error: File not found. Please enter a valid file path.");
            System.exit(0);
        }
        if(!comparisonType.equals("b")&&!comparisonType.equals("h")&&!comparisonType.equals("v")) { //validates the comparison type
        	System.out.println("Error: Please enter a valid sorting type.  v for volume sorting, b for base area"
        			+ " sorting and h for height sorting.");
            System.exit(0);
        }

    }
	/**
	 * First creates a scanner object from the filelocation parsed from the command line arguments.
	 * It will read in the first value and use it to create an array of that size.  The file is written in a pattern
	 * of Shape type, height, side/radius.  It will use a loop to use reflection to create the correct object with the
	 * parameters.  It will then fill the array with the Shape object.
	 */
	public void fillArray() {
		try { //create file and assign first value in file to be array size
			Scanner file = new Scanner(new File(fileLocation));
			int arraySize=Integer.parseInt(file.next());
			shapes=new Shape[arraySize];
			
			int currentValueInArray=0;
			Long start,end;
			start=System.currentTimeMillis();
			while(file.hasNext())
			{ //loops through objects and creates objects using reflection
				Object o = null;
				String className = "problemdomain."+file.next();				
				Class cls = Class.forName(className);
				
				Class paramTypes[] = new Class[2];
				paramTypes[0] = Double.TYPE;
				paramTypes[1] = Double.TYPE;
				
				Constructor ct = cls.getConstructor(paramTypes);
				
				Object argList[] = new Object[2];
				argList[0] = new Double((file.nextDouble()));
				argList[1] = new Double((file.nextDouble()));
				o = ct.newInstance(argList);
				shapes[currentValueInArray]=(Shape) o;
				currentValueInArray++;
			}
			file.close();
			end=System.currentTimeMillis();
			fileReadTime=(int) (end-start);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * Calls the sorting algorithm, then it calls printSort method to print every 1000th element of the sorted array
	 * and finally prints the amount of time it took to sort the array.
	 * Uses a switch case to determine the type of sorting algorithm to call.
	 * @param sortingAlgorithm Sorting algorithm parsed from command line arguments
	 * @param comparisonType Comparison type parsed from command line arguments
	 */
	private void callSort(String sortingAlgorithm, String comparisonType) {
		Long start;
		Long end;
		switch(sortingAlgorithm.toLowerCase()) { //switch case for sorting method.  if none of the cases match, error printed and terminates
		case "b":
            BubbleSort bs=new BubbleSort(comparisonType);
            start=System.currentTimeMillis();
            bs.sort(shapes);
            end=System.currentTimeMillis();
            printSortedArray();
            System.out.println("Time to read file: " +fileReadTime+" Milliseconds");
            System.out.println("Time to complete Bubble Sort: " +(end-start)+" Milliseconds");
            System.out.println();
            break;
        case "s":
        	SelectionSort ss=new SelectionSort(comparisonType);
        	start=System.currentTimeMillis();
            ss.sort(shapes);
            end=System.currentTimeMillis();
            printSortedArray();
            System.out.println("Time to read file: " +fileReadTime+" Milliseconds");

            System.out.println("Time to complete Selection Sort: " +(end-start)+" Milliseconds");
            System.out.println();
            break;
        case "i":
        	InsertionSort is=new InsertionSort(comparisonType);
        	start=System.currentTimeMillis();
            is.sort(shapes);
            end=System.currentTimeMillis();
            printSortedArray();
            System.out.println("Time to read file: " +fileReadTime+" Milliseconds");
            System.out.println("Time to complete Insertion Sort: " +(end-start)+" Milliseconds");
            System.out.println();
            break;
        case "m":
        	MergeSort ms=new MergeSort(comparisonType);
        	start=System.currentTimeMillis();
            ms.sort(shapes);
            end=System.currentTimeMillis();
            printSortedArray();
            System.out.println("Time to read file: " +fileReadTime+" Milliseconds");
            System.out.println("Time to complete Merge Sort: " +(end-start)+" Milliseconds");
            System.out.println();
            break;
        case "q":
        	QuickSort qs=new QuickSort(comparisonType);
        	start=System.currentTimeMillis();
            qs.sort(shapes);
            end=System.currentTimeMillis();
            printSortedArray();
            System.out.println("Time to read file: " +fileReadTime+" Milliseconds");
            System.out.println("Time to complete Quick Sort: " +(end-start)+" Milliseconds");
            System.out.println();
        	break;
        case "z":
        	HeapSort hs=new HeapSort(comparisonType);
        	start=System.currentTimeMillis();
        	hs.sort(shapes);
            end=System.currentTimeMillis(); // 
            printSortedArray();
            System.out.println("Time to read file: " +fileReadTime+" Milliseconds");
            System.out.println("Time to complete Heap Sort: " +(end-start)+" Milliseconds");
            System.out.println();
            break;
        default:
            System.out.println("Error: Invalid sort type. Please enter 'b' for bubble, 's' for selection, 'i' for insertion, 'm' for merge, 'q' for quick, or 'z' for your choice of sorting algorithm.");
            System.exit(0);
		}
		
	}


	/**
	 * Prints every 1000th element of the sorted array and the last value
	 */
	private void printSortedArray() {
		for(int i=0;i<shapes.length;i+=1000) { 
			if((i+1000)>shapes.length) { //printing the last value of the array
				System.out.println(shapes[shapes.length-1]);
				break;
			}
			System.out.println(shapes[i]);
		}

		
	}

}
