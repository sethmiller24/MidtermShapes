
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/*
 * Parses the Shapes in the XML file
 */
public class XMLRead extends DefaultHandler {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private String chars;
	private Shape currShape;

	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	/**
	 * When identified as a shape, creates that shape with the given attributes
	 */
	public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
		if (localName.equals("circle")) {
			Circle c = new Circle();
			c.ID = (Integer.parseInt(atts.getValue("id")));
			c.radius = (Integer.parseInt(atts.getValue("radius")));
			c.setColor(atts.getValue("color"));
			shapes.add(c);
		} else if (localName.equals("rectangle")) {
			Rectangle c = new Rectangle();

			try {
				c.ID = (Integer.parseInt(atts.getValue("id")));
				c.length = (Integer.parseInt(atts.getValue("length")));
				c.width = (Integer.parseInt(atts.getValue("width")));
				c.setColor(atts.getValue("color"));
			} catch (Exception e) {
				System.out.println(e);
			}
			shapes.add(c);
		} else if (localName.equals("triangle")) {
			Triangle c = new Triangle();
			c.ID = (Integer.parseInt(atts.getValue("id")));
			c.side1 = (Integer.parseInt(atts.getValue("side1")));
			c.side2 = (Integer.parseInt(atts.getValue("side2")));
			c.side3 = (Integer.parseInt(atts.getValue("side3")));
			c.setColor(atts.getValue("color"));
			
			shapes.add(c);

		} else if (localName.equals("square")) {
			Square c = new Square();
			c.ID = (Integer.parseInt(atts.getValue("id")));
			c.sideLeng = (Integer.parseInt(atts.getValue("side")));
			c.setColor(atts.getValue("color"));
			shapes.add(c);
		}
	}
}
