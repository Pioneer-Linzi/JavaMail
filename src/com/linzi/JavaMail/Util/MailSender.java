package com.linzi.JavaMail.Util;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.linzi.JavaMail.sendmail.SetProperties;

/**
 * 用过初始化mail的发送的过程，
 * 略去设置邮箱中的各种的过程，直接从配置文件中读取要发送的内容与基本的配置文件 
 * 只要用setTo("mailaddress@host");来设置发送给谁就行了，
 * 然后调用sendMessage();来发送邮件
 * 
 * @author PCPC
 * 
 */

public class MailSender {
	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	private String host;
	private String username;
	private String password;
	private String from;
	private String content;
	private String subject;
	MimeMessage msg;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	private String to;
	/**
	 * 用以建 session 
	 * message 中的各各参数的设置
	 * @throws AddressException
	 * @throws MessagingException
	 */

	protected void mailPropSet() throws AddressException, MessagingException {
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", host);
		props.setProperty("mail.smtp.auth", "true");

		/**
		 * 创建认证
		 */
		Authenticator auth = new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}

		};
		Session session = Session.getInstance(props, auth);

		// 创建邮件信息的对像
		msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(RecipientType.TO, to);
		msg.setSubject(subject);
		msg.setContent(content, "text/html;charset=utf-8");

		// 发送邮件

	}

	public void sendMessage() throws MessagingException {
		mailPropSet();
		Transport.send(msg);
	}

	/**
	 * 用以初始化各种参数，设置邮箱。
	 * 
	 * @throws IOException
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public MailSender() throws IOException, AddressException,
			MessagingException {
		SetProperties setProperties = new SetProperties();
		this.content = setProperties.getContent();
		this.from = setProperties.getFrom();
		this.host = setProperties.getHost();
		this.password = setProperties.getPassword();
		this.subject = setProperties.getSubject();
		this.username = setProperties.getUsername();
	

	}

}
