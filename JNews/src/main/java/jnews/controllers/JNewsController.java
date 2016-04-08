package jnews.controllers;

import jnews.model.News;
import jnews.repository.NewsService;
import jnews.utils.Actuator;
import jnews.utils.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Akhmat on 06.04.2016.
 */
@Controller
public class JNewsController {

    @Autowired
    private NewsService newsService;

    public static boolean isEmailValid = false;
    private static String correctEmail;

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        if(!isEmailValid)
            return "index";
        else
            return "redirect:main";
    }

    @RequestMapping(value = {"search"}, method = RequestMethod.GET)
    public String check(ModelMap modelMap,@RequestParam("email") String email) {
        if(MailSender.isValid(email)){
            correctEmail =email;
            isEmailValid=true;
            return "redirect:main";
        }
        return "index";
    }

    @RequestMapping(value = {"main"}, method = RequestMethod.GET)
    public String main(ModelMap modelMap,@ModelAttribute News news) {
        List<News> newsList;
        while (true){
             newsList = newsService.getAllNews();
            if(newsList==null||!(newsList.size()>0)){
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //continue;
            }
            else break;
        }
        modelMap.addAttribute("newsList",newsList);
        return "main";
    }

    @Scheduled(fixedDelay = 86400000)
    void scheduler(){
        while(true){
            if (!isEmailValid)
                try {
                    java.lang.Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            else
                break;
        }

        Actuator actuator = new Actuator(newsService,correctEmail);
        actuator.actuate();
        actuator.send();
    }
}
