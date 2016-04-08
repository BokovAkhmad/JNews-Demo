package jnews.repository;

import jnews.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Akhmat on 05.04.2016.
 */

@Service
@Transactional
public class NewsService  {

    @Autowired
    private NewsRepository newsRepository;

    public List<News> saveNews(List<News> newsList){

        List<News> savedNews = new ArrayList<>();
        List<News> allNews =(List<News>) newsRepository.findAll();
        List<String> titlesOfNews = new ArrayList<>();

        for(News news: allNews){
            titlesOfNews.add(news.getTitle());
        }
        for(News news: newsList){
            if(!titlesOfNews.contains(news.getTitle())){
                newsRepository.save(news);
                savedNews.add(news);
            }
        }
        return savedNews;
    }

    public List<News> getJavaNews(List<News> newsList){
        String regex = "\\bjava\\b";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        List<News>javaNews=new ArrayList<>();

        for(News news:newsList){
            Matcher matcher = pattern.matcher(news.getTitle());
            if(matcher.find())
                javaNews.add(news);
        }
        return javaNews;
    }
    public List<News> getAllNews(){

        List<News> allNews =(List<News>) newsRepository.findAll();
        return allNews;
    }
}
