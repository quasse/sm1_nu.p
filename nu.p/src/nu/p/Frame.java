package nu.p;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import org.apache.log4j.Logger;

public class Frame {

	private JFrame frame;
	private final Dimension FRAME_DIMENSION = new Dimension(700,500); //The dimension of the frame.
	private final String FRAME_NAME = "News Stream";
	private Stream stream = new Stream();
	private Logger logger;

	public Frame(Logger logger) throws URISyntaxException{


		//Gets the first Reddit link
		String elm = stream.getNextRedditElement();
		String[] parts = elm.split("-");
		String headline = parts[0];
		String link = parts[1];

		final URI uri = new URI("http://java.sun.com");

		//initializes logger
		this.logger = logger;

		//Creates the frame
		frame = new JFrame(FRAME_NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(FRAME_DIMENSION);
		Container container = frame.getContentPane();

		container.setLayout(new GridBagLayout());
		JButton button = new JButton();
		button.setText("<HTML>Click the <FONT color=\"#000099\"><U>link</U></FONT>"
				+ " to go to the Java website.</HTML>");
		button.setHorizontalAlignment(SwingConstants.LEFT);
		button.setBorderPainted(false);
		button.setOpaque(false);
		button.setBackground(Color.WHITE);
		button.setToolTipText(uri.toString());
		button.addActionListener(new OpenUrlAction(uri));
		container.add(button);
		/**
		//Sets up EditorPane
		JEditorPane editor = new JEditorPane();
		editor.setEditable(false);
		editor.setForeground(Color.GREEN);
		editor.setBackground(Color.BLACK);


		//Sets up a text area 
		JTextArea area = new JTextArea();
		area.setEditable(false);
		area.setLineWrap(true);
		area.setForeground(Color.GREEN);
		area.setBackground(Color.BLACK);
		area.append(headline);

		frame.getContentPane().add(area, BorderLayout.PAGE_START);**/
		frame.setVisible(true);
	}

	public String nextElements(){
		return stream.getNextRedditElement();
	}
}
