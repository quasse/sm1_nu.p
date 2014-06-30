package nu.p;

/**
 * Class in which all the websites information is interpreted.
 * @author smorgen
 *
 */
public class Stream {
	
	Reddit reddit;
	
	public Stream(){
		reddit = new Reddit();
	}
	
	public String getNextRedditElement(){
		return reddit.getNextElement();
	}
}
