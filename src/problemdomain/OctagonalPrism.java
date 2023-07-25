package problemdomain;
/**
 * OctagonalPrism object extending Shape
 * @author Hussein
 *
 */
public class OctagonalPrism extends Shape {
		
	private double side;


	/**
	 * Creates an OctagonalPrism object
	 * @param height Height
	 * @param side Side
	 */
	public OctagonalPrism(double height,double side) {
		super(height);
		this.side = side;
	}
	/**
	 * Gets the side
	 * @return side
	 */
	public double getSide() {
		return side;
	}
	/**
	 * Calculates the volume when the object is instantiated. When called from the sorting algorithm it will 
	 * only return the volume to save time when sorting
	 */
	@Override
	public double calcVolume() {
		if(volume<0) {
			volume=calcBaseArea()*this.getHeight();
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
			baseArea= 2.0*(1.0*Math.sqrt(2.0))*side*side;
		}
		return baseArea;
	}
	/**
	 * Overrided toString method
	 */
	@Override
	public String toString() {
		String returnstatement= String.format("%-20s%10s%15f%10s%15f%10s%28f%15s%20f"
				,"OctagonalPrism:","Height: ",this.getHeight(),"Side: ",side,"Volume: ",this.calcVolume(),"Base Area: ",
				this.calcBaseArea());
		return   returnstatement;
	}
	
	
}
