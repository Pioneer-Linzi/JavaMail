package com.linzi.JavaMail;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import com.linzi.JavaMail.Util.MailSender;

public class testDemo {
	
	public static void main(String[] args) {
		MailSender ms;
		try {
			ms = new MailSender();
			ms.setTo("linlin_zhao@yeah.net");
			ms.sendMessage();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
