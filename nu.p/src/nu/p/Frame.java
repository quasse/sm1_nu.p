package nu.p;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import org.apache.log4j.Logger;

public class Frame {

	private JFrame frame;
	private final Dimension FRAME_DIMENSION = new Dimension(700,500); //The dimension of the frame.
	private final String FRAME_NAME = "News Stream";
	private Stream stream = new Stream();
	private Logger logger;
	
	public Frame(Logger logger){

		//initializes logger
		this.logger = logger;
		
		
		//Creates the frame
		frame = new JFrame(FRAME_NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_DIMENSION);
		frame.getContentPane().setBackground(Color.black);
		
		//Sets up EditorPane
		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.setForeground(Color.GREEN);
		editor.setBackground(Color.BLACK);

		//Gets the first Reddit link
		String elm = stream.getNextRedditElement();
		String[] parts = elm.split("-");
		String headline = parts[0];
		String link = parts[1];
		
		//Sets up a text area 
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setLineWrap(true);
		area.setForeground(Color.GREEN);
		area.setBackground(Color.BLACK);
		area.append(headline);
		
		
		
		//Sets up hyperlink
		URL url = null;
		try {
			url = new URL(link);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		HyperlinkEvent event = new HyperlinkEvent(area, 
				HyperlinkEvent.EventType.ENTERED, url);

		frame.getContentPane().add(area, BorderLayout.PAGE_START);
		frame.setVisible(true);
	}
	
	public String nextElements(){
		return stream.getNextRedditElement();
	}
}
