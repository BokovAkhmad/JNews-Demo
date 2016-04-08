package jnews.utils;

import com.sun.syndication.feed.synd.SyndEntry;
import jnews.model.News;
import jnews.repository.NewsService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Akhmat on 05.04.2016.
 */

public class Actuator {
    private String email;
    private NewsService newsService;
    private List<News> javaNews;

    public Actuator(NewsService newsService, String email) {
        this.newsService = newsService;
        this.email = email;
    }

    public void actuate(){
            List<News> newsList = new ArrayList<>();
            ArrayList<Object> entries =  new ArrayList<>(RssReceiver.getNewsFeed().getEntries());
            for(int i =0; i<=9;i++){
                SyndEntry entry = (SyndEntry) entries.get(i);
                News news = new News();
                news.setTitle(entry.getTitle());
                news.setLink(entry.getLink());
                newsList.add(news);
            }
            List<News> savedNews = this.newsService.saveNews(newsList);
            javaNews = this.newsService.getJavaNews(savedNews);
    }

    public void send(){
        if(javaNews.size()>0&&javaNews!=null){
            MailSender mailSender = new MailSender(this.email);
            mailSender.send(new Date(),javaNews);
        }
    }
}
