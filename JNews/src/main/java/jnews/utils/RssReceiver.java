package jnews.utils;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;

/**
 * Created by Akhmat on 02.04.2016.
 */
public class RssReceiver {
    public static final String newsResource = "http://www.javaworld.com/news/index.rss";

    public static SyndFeed getNewsFeed(){
        SyndFeed syndFeed = null;
        SyndFeedInput syndFeedInput = new SyndFeedInput();
        try {
            syndFeed = syndFeedInput.build(new XmlReader(new URL(newsResource)));
        } catch (FeedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return syndFeed;
    }
}
