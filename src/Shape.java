import java.awt.Color;

public interface Shape {
	/**
	 * 
	 * @return - Kind of Shape + ID
	 */
	String toString();
	/**
	 * 
	 * @return - The Kind of Shape
	 */
	String getKind();
	/**
	 * 
	 * @return A string containing the kind, id, measurements, color, area and perimeter
	 */
	String getDetailString();
	/**
	 * 
	 * @return - the ID
	 */
	int getID();
	/**
	 * calculates the area based off it's shape and measurements
	 * @return - the area
	 */
	double calcArea();
	/**
	 * calculates the perimeter based off it's shape and measurements
	 * @return - the perimeter of this shape
	 */
	int calcPerim();
	
	/**
	 * converts the string into the appropriate color
	 * @param color - A string from the XML reader to turn into the proper color
	 */
	void setColor(String color);
	/**
	 * Helper method to set the color in Shapes UI
	 * @return - the Color color
	 */
	Color getColor();
}
