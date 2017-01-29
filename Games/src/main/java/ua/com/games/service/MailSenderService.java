package ua.com.games.service;

public interface MailSenderService {

	void sendMail(String theme, String mailBody, String email);
	
}
