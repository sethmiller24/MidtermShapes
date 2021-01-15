import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

/**
 * Represents the UI component to show off the shapes held within shapes.xml
 * @author Seth Miller
 * @version 1.0.0 1/15/2021
 */
public class ShapesUI extends javax.swing.JComponent implements MouseMotionListener, ActionListener{
	ArrayList <Shape> shapes;
	int currShape = 0;
	int x, y;
	
	JButton next;
	JButton prev;
	
	JPanel shpBtnList;
	
	ShapesUI(){
		init();
	}
	
	/**
	 * Sets all of the attributes listed above
	 */
	public void init() {
		parseFile();
		x = 100;
		y = 100;
		
		this.setLayout(new FlowLayout());
		
		//shpBtnList = new JPanel();
		
		next = new JButton ("Next Shape");
		next.addActionListener(this);
		prev = new JButton ("Previous Shape");
		prev.addActionListener(this);
		
		this.add(next);
		this.add(prev);
		
		addMouseMotionListener(this);
		
	}
	
	/**
	 * Reads the file "shapes.xml" to fill the shapes ArrayList
	 */
	public void parseFile() {
		try {
	        SAXParserFactory spf = SAXParserFactory.newInstance();
	        spf.setNamespaceAware(true);
	        SAXParser saxParser = spf.newSAXParser();
	        XMLReader xmlrdr = saxParser.getXMLReader();
	        XMLRead shaperdr = new XMLRead();
	        xmlrdr.setContentHandler(shaperdr);
	        xmlrdr.parse("shapes.xml");
	        
	        shapes = shaperdr.getShapes();	        
	    }
	    catch (Exception ex) { 
	    	System.out.printf("Failed with error %s\n", ex.getLocalizedMessage());
	    }
	}
	
	//Calls the more complicated paint methods
	public void paintComponent (Graphics g) {
		paintShapeList(g);
		paintCurrShape(g);
	}
	
	/**
	 * Prints out the ArrayList of Shapes' toString's, the one in red being the selected one
	 * @param g
	 */
	public void paintShapeList(Graphics g) {
		for (int i = 0; i < shapes.size(); i++) {
			if (i == currShape) {
				g.setColor(Color.red);
			}else {
				g.setColor(Color.black);
			}
			if (i>=65) {
				g.drawString(shapes.get(i).toString(), 100, 10+(10*(i-65)));
			}else {
				g.drawString(shapes.get(i).toString(), 0, 10+(10*i));
			}
		}
	}
	
	/**
	 * Draws a shape based off it's kind, color and measurements
	 * Draws the detailedString too
	 * @param g
	 */
	public void paintCurrShape(Graphics g) {
		Shape temp = shapes.get(currShape);
		g.setColor(temp.getColor());
		if (temp.getKind().equals("Circle")){
			g.fillOval(x+10, y+10, ((Circle)temp).radius*25, ((Circle)temp).radius*25);
		}else if (temp.getKind().equals("Rectangle")){
			g.fillRect(x+10, y+10, ((Rectangle) temp).length*25, ((Rectangle) temp).width*25);
		}else if (temp.getKind().equals("Square")){
			g.fillRect(x+10, y+10, ((Square) temp).sideLeng*25, ((Square) temp).sideLeng*25);
		}else if (temp.getKind().equals("Triangle")){
			//will result in a right triangle for the moment
			int [] xPoints = {x, (((Triangle) temp).side1*25)+x,x};
			int [] yPoints = {y,y,(((Triangle) temp).side2*25)+y};
			g.fillPolygon(xPoints, yPoints, 3);
					
		}
		//Default the color back to black for the text
		g.setColor(Color.black);
		g.drawString(temp.getDetailString(), x, y);
	}

	/**
	 * With the buttons, cycles through the list of Shapes
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == next && currShape < shapes.size()-1) {
			currShape++;
		}else if (e.getSource()==prev && currShape>0) {
			currShape--;
		}
		repaint();
	}

	/**
	 * Allows User to drag the shape around
	 */
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
