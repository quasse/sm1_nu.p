package nu.p;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

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
		
		
		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.setForeground(Color.GREEN);
		editor.setBackground(Color.BLACK);
		HyperlinkEvent event = new HyperlinkEvent();
		HyperlinkListener listener = new HyperlinkListener(event);
		editor.addHyperlinkListener(listener);
		
		
		//Sets up a text area 
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setLineWrap(true);
		area.setForeground(Color.GREEN);
		area.setBackground(Color.BLACK);
		area.append("hi");

		frame.getContentPane().add(area, BorderLayout.PAGE_START);
		frame.setVisible(true);
	}
	
	public String nextElements(){
		return stream.getNextRedditElement();
	}
}
