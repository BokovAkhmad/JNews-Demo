package jnews;

import jnews.controllers.JNewsController;
import jnews.repository.NewsService;
import jnews.utils.Actuator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;


@ComponentScan
@SpringBootApplication
public class JNewsApplication extends SpringBootServletInitializer{




    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JNewsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(JNewsApplication.class, args);
    }

   /* @Override
    public void run(String... strings) throws Exception {
        /*java.lang.Thread tt = new java.lang.Thread(rrr);
        tt.run();*/

}


