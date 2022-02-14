import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		JFrame frame = new ProductUI();												//Create object Frame of Hangman
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Add/Update Product");													//Set Title of Frame
		frame.setVisible(true);														//Set Frame visibility
		frame.setSize(650,300); 
	}

}
