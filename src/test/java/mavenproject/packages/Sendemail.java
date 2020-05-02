package mavenproject.packages;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Sendemail {

	public static void main(String[] args) throws EmailException {
		
		System.out.println("==========Test Started===========");
		
		Email email = new SimpleEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("venki07i12@gmail.com", "venkateshippa"));
		email.setSSLOnConnect(true);
		email.setFrom("venkatesh.ippa@gmail.com");
		email.setSubject("TestMail7");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("mukeshotwani@learn-automation.com");
		email.send();
		
		System.out.println("==========Email sent===========");
		
	}

}
