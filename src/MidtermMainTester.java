import java.util.ArrayList;

import javax.swing.JFrame;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class MidtermMainTester {

	//Build the frame and ready the UI
	public static void main(String[] args) {
		
		//Build the frame out here, I've had trouble getting repaint to work in the same class as JFrame
		JFrame frame = new JFrame("Shapes Midterm");
		ShapesUI ui = new ShapesUI();
		frame.add(ui);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,1000);
		frame.setVisible(true);
	}

}
