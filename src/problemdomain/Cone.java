package problemdomain;
/**
 * Cone object extending Shape
 * @author Hussein
 *
 */
public class Cone extends Shape {
		
	private double radius;


	/**
	 * Creates a cone object
	 * @param height Height
	 * @param radius Radius
	 */
	public Cone(double height,double radius) {
		super(height);
		this.radius = radius;
	}
	/**
	 * Gets the radius
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
	/**
	 * Calculates the volume when the object is instantiated. When called from the sorting algorithm it will 
	 * only return the volume to save time when sorting
	 */
	@Override
	public double calcVolume() {
		if(volume<0) {
			volume=calcBaseArea()*this.getHeight()*1.0/3;
		}
		return volume;
	}
	/**
	 * Calculates the base area when the object is instantiated. When called from the sorting algorithm it will 
	 * only return the base area to save time when sorting
	 */
	@Override
	public double calcBaseArea() {
		if(baseArea<0) {
			baseArea=Math.PI*radius*radius;
		}
		return baseArea;
	}
	/**
	 * Overrided toString method
	 */
	@Override
	public String toString() {
		String returnstatement= String.format("%-20s%10s%15f%10s%15f%10s%28f%15s%20f"
				,"Cone: ","Height: ",this.getHeight(),"Radius: ",radius,"Volume: ",this.calcVolume(),"Base Area: ",
				this.calcBaseArea());
		return   returnstatement;
	}
	
	
}
