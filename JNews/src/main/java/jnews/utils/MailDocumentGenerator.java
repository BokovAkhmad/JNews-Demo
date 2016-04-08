package jnews.utils;

import jnews.model.News;

import java.util.List;

/**
 * Created by Akhmat on 04.04.2016.
 */
public class MailDocumentGenerator {
    private List<News> newsList;

    public MailDocumentGenerator(List<News> newsList) {
        this.newsList = newsList;
    }

    public String getTextForEmail(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Hello my friend, see news from Java World!\n");
        for(int i =1; i<=this.newsList.size();i++)
        {
            stringBuilder.append(i+". "+newsList.get(i-1)+"\n");
        }
        return stringBuilder.toString();
    }

}
