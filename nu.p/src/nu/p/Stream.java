package nu.p;

import java.net.URL;

/**
 * Class in which all the websites information is interpreted.
 * @author smorgen
 *
 */
public class Stream {
	
	private Reddit reddit;
	
	public Stream(){
		reddit = new Reddit();
	}
	
	public String getNextRedditElement(){
		return reddit.getNextElement();
	}
}
