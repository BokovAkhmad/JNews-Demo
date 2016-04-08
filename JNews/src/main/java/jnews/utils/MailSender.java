package jnews.utils;

import jnews.model.News;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * Created by Akhmat on 02.04.2016.
 */
// login: testjavanews@gmail.com
// password: javajavajava

public class MailSender {
    private final static String OWNER_LOGIN = "testjavanews@gmail.com";
    private final static String OWNER_PASSWORD = "javajavajava";
    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM", Locale.ENGLISH);

    private Properties properties;
    private String toEmail;
    private static Matcher matcher;
    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static  Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    public MailSender(String toEmail) {
        properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "465");
        this.toEmail= toEmail;
    }

    public static boolean isValid(String email){
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void send(Date date, List<News> newsList){
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(OWNER_LOGIN, OWNER_PASSWORD);
            }
        });
        try {
            MailDocumentGenerator mailDocumentGenerator = new MailDocumentGenerator(newsList);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(OWNER_LOGIN));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.toEmail));
            message.setSubject("See Java news at "+dateFormat.format(date));
            message.setText(mailDocumentGenerator.getTextForEmail());

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

  /*  public static void main(String[] args) {
        MailSender mailSender = new MailSender("bokovakhmad@gmail.com");
        List<News> newsList = new ArrayList<>();

        for(int i = 0; i<10; i++){
            News news = new News();
            news.setTitle("Java best practice");
            news.setLink("www.java.com");
            newsList.add(news);
        }

        mailSender.send(new Date(),newsList);
    }*/
}
