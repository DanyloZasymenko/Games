package ua.com.games.serviceImpl;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import ua.com.games.service.MailSenderService;

@Service
public class MailSenderServiceImpl implements MailSenderService{

	private static final String USERNAME = "danik1492@gmail.com";
	private static final String PASSWORD = "nastusia";
	
	@Override
	@Async
	public void sendMail(String theme, String mailBody, String email) {
		
		 Properties properties = System.getProperties();
	        properties.setProperty("mail.smtp.starttls.enable", "true");
	        properties.setProperty("mail.smtp.auth", "true");
	        properties.setProperty("mail.smtp.port", "465");
	        properties.setProperty("mail.smtp.host", "smtp.gmail.com");
	        properties.setProperty("mail.smtp.socketFactory.port", "465");
	        properties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	        Session session = Session.getDefaultInstance(properties,
	                new Authenticator() {
	                    protected PasswordAuthentication getPasswordAuthentication() {
	                        return new PasswordAuthentication(USERNAME, PASSWORD);
	                    }
	                });
	        try {
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(USERNAME));

	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
	            message.setSubject(theme, "UTF-8");
	            message.setText(mailBody);
	            synchronized (this) {
	                Transport.send(message);
	            }
	        } catch (MessagingException mex) {
	            mex.printStackTrace();
	            System.out.println("You have some problems with connection!");
	        }
		
		
	}

}
