package problemdomain;

import java.util.*;
/**
 * Abstract Shape class implementing comparable to compare the height of any shape
 * @author Hussein
 *
 */
public abstract class Shape implements Comparable<Shape>{
		
	private double height;
	double baseArea = -1;
	double volume = -1;
	/**
	 * Sets the height of the shape
	 * @param height height
	 */
	public Shape(double height){
		this.height=height;
	}
	/**
	 * gets the height
	 * @return height
	 */
	public double getHeight() {
		return height;
	}
	/**
	 * Abstract method implemented in every shape object.  Calculates the volume of the shape
	 * @return Volume
	 */
	public abstract double calcVolume();
	/**
	 * Abstract method implemented in every shape object.  Calculates the base area of the shape
	 * @return Base area
	 */
	public abstract double calcBaseArea();
	/**
	 * CompareTo method.  Compares the height of any shape and returns a value above,below, or equal to zero
	 * Used in every sorting algorithm to sort by height
	 */
	@Override
	public int compareTo(Shape that)
	{
		return Double.compare(this.height, that.height);
	}
}

