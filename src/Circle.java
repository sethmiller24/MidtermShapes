import java.awt.Color;

/*
 * Represents the Circle Shape, implementing Shape's methods
 * Circle has unique way for finding area and perimeter + radius is unique attribute
 */
public class Circle implements Shape{
	private String kind = "Circle";
	private Color color;
	int ID;
	int radius;
	
	
	public String toString() {
		return kind + "(ID# " + ID +")"; 
	}
	public String getKind() {
		return kind;
	}
	public String getDetailString() {
		String str = toString();
		str += " | Color:" + this.color.toString();
		str += " | Radius: " +this.radius;
		
		//Tag pi on to not complicate the calculation too much
		str += " | Area: " + calcArea() + "pi";
		str += " | Perimeter: "+calcPerim()+"pi";
		return str;
	}
	public int getID() {
		return ID;
	}

	//Use Circle specific math to determine the area and circumference (without pi)
	public double calcArea() {
		// TODO Auto-generated method stub
		return radius*radius;
	}

	public int calcPerim() {
		// TODO Auto-generated method stub
		return 2*radius;
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
