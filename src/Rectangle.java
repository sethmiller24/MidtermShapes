import java.awt.Color;

/*
 * Represents the Square Shape, implementing Shape's methods
 * Rectangle has unique way for finding area and perimeter + length and width are unique attributes
 */
public class Rectangle implements Shape {
	private String kind = "Rectangle";
	private Color color;
	int ID;
	int length;
	int width;
	
	
	public String toString() {
		return kind + "(ID# " + ID +")"; 
	}
	public String getKind() {
		return kind;
	}
	public String getDetailString() {
		String str = toString();
		str += "\nColor:" + this.color.toString();
		str += "\nLength: " +this.length;
		str += "\nWidth: " + this.width;
		str += "\nArea: " + calcArea();
		str += "\nPerimeter: "+calcPerim();
		return str;
	}
	public int getID() {
		return ID;
	}

	public double calcArea() {
		// TODO Auto-generated method stub
		return length*width;
	}

	public int calcPerim() {
		// TODO Auto-generated method stub
		return (2*length)+(2*width);
	}
	
	
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
