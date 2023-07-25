package comparisons;

import java.util.Comparator;
import problemdomain.*;
/**
 * Base area compare for shape objects.  Implements the comparison operator to compare the objects.  Used in the sorting 
 * algorithms to properly sort the Shapes
 * @author Hussein
 *
 */
public class BaseAreaCompare implements Comparator<Shape>
{
	/**
	 * takes 2 shape objects and compares the base area.  Returns a value below, equal to, or above 0 based
	 *  on the comparison
	 *  
	 *  @param shape1 First shape to compare
	 *  @param shape2 Second shape to compare
	 */
	@Override
	public int compare(Shape shape1, Shape shape2)
	{
		return Double.compare(shape1.calcBaseArea(), shape2.calcBaseArea());

	}

}

