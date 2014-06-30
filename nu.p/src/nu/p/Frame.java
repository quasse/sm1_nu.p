package nu.p;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Frame {

	private JFrame frame;
	//The dimension of the frame.
	private final Dimension FRAME_DIMENSION = new Dimension(700,500);
	private final String FRAME_NAME = "News Stream";
	private Stream stream;
	
	public Frame(){

		//Creates the frame
		frame = new JFrame(FRAME_NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_DIMENSION);
		frame.getContentPane().setBackground(Color.black);
		
		/*
		 * Creates the test labels to be added
		 */
		JLabel label = new JLabel("test");
		label.setForeground(Color.GREEN);
		label.setLocation(40, 10);

		//Adds the label to the frame
		frame.getContentPane().add(label);
		
		frame.setVisible(true);
	}
}
