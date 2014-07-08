package nu.p;

import java.net.URISyntaxException;

import org.apache.log4j.*;

public class Main {

	private static Logger logger = Logger.getLogger(Stream.class);
	
	public static void main(String[] args) throws URISyntaxException {
		
		//Initialize the Logger
		BasicConfigurator.configure();
		
		//Creates the Frame
		Frame frame = new Frame(logger);
		
		
	}

}
