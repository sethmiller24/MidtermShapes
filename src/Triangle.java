import java.awt.Color;

/*
 * Represents the Square Shape, implementing Shape's methods
 * Triangle has unique way for finding area and perimeter + side1, side2 and side3 are unique attributes
 */
public class Triangle implements Shape {
	private String kind = "Triangle";
	private Color color;
	int ID;
	int side1;
	int side2;
	int side3;
		
	public String toString() {
		return kind + "(ID# " + ID +")"; 
	}
	public String getKind() {
		return kind;
	}
	public String getDetailString() {
		String str = toString();
		str += "\nColor:" + this.color.toString();
		str += "\nSide 1: " +this.side1;
		str += "\nSide 2: " +this.side2;
		str += "\nSide 3: " +this.side3;
		str += "\nArea: " + calcArea();
		str += "\nPerimeter: "+calcPerim();
		return str;
	}
	public int getID() {
		return ID;
	}

	//Based off of https://www.petervis.com/mathematics/area_of_triangle/area-of-a-triangle-given-3-sides-herons-formula.html
	public double calcArea() {
		// TODO Auto-generated method stub
		float s = (side1+side2+side3)/2;
		
		return Math.sqrt((s*(s-side1)*(s-side2)*(s-side3)));
	}

	public int calcPerim() {
		// TODO Auto-generated method stub
		return side1+side2+side3;
	}
	
	@Override
	public void setColor(String color) {
		// TODO Auto-generated method stub
		if (color.equals("red")) {
			this.color = Color.red;
		}else if (color.equals("blue")) {
			this.color = Color.blue;
		}else if (color.equals("yellow")) {
			this.color = Color.yellow;
		}else if (color.equals("green")) {
			this.color = Color.green;
		}else {
			this.color = Color.black;
		}
	}
	
	public Color getColor() {
		return color;
	}
}
