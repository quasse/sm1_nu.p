package nu.p;

import de.dbsystems.simplescrape.HTMLTag;
import de.dbsystems.simplescrape.HTTPHelper;
import de.dbsystems.simplescrape.Scraper;

public class Reddit {

	private HTTPHelper helper = new HTTPHelper();
	private Scraper scraper; 
	private HTMLTag tag;
	private HTMLTag link;

	/**
	 * Initializes a scraper for reddit.com
	 * Goes to the correct spot in reddit to get the headline and link.
	 */
	public Reddit(){
		scraper = helper.getWebpageForScraping("http://www.reddit.com/");
		HTMLTag tag = scraper.getNextTag();

		/*
		 * Goes through each tag until it finds the tag containing "sitetable".
		 * The tag containing "sitetable" is where all the valuable content of 
		 * Reddit is stored. 
		 */
		boolean done = false;
		while (!done){
			tag = scraper.getNextTag();
			if(tag.toString().contains("sitetable")){
				done = true;
			}
		}
	}
	
	/**
	 * Returns a string of the headline and the link to the headline, separated
	 * by a "|".
	 * @return
	 */
	public String getNextElement(){
		String elm = getHeadline() + "|" + getLink();
		advance();
		return elm;
	}
	/**
	 * This method starts in the section of the Reddit HTML code where all the 
	 * links and titles are stored. It searches through the HTML file until the 
	 * tag containing "title" is found. When it is found. It returns the
	 * TextToken containing the headline of the entry.
	 * 
	 * In addition, this method, once it reaches the section of the HTML file 
	 * with hte tag containing title, it saves the link the title is referencing
	 * under the variable "link". 
	 * @return
	 */
	private String getHeadline(){
		while (scraper.hasNext()){
			tag = scraper.getNextTag();
			if (tag.toString().contains("title")){
				Scraper tmp = scraper;
				link = tmp.getNextTag();
				return scraper.getNextText(true).toString();
			}
		}
		return null;
	}

	/**
	 * Gets the attribute title "href" and returns it. 
	 * 
	 * If the reference is referencing a subreddit, the string 
	 * "http://www.reddit.com is added to the beginning of the string.
	 * @return
	 */
	private String getLink(){
		String address = link.getAttributes().get("href");
		if (address.contains("/r/"))
			address = "http://www.reddit.com" + address;
		return address;
	}

	/**
	 * Advances the Scraper to the next Reddit entry.
	 */
	private void advance(){
		while (scraper.hasNext()){
			if (tag.toString().contains("thing")){
				return;
			}
			tag = scraper.getNextTag();
		}
	}
}
