package com.gx.utils;

import java.util.Properties;
//import java.util.ResourceBundle;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {

	public static void sendMail(String email, String emailMsg) throws AddressException, MessagingException {
		// 1.创建一个程序与邮件服务器会话对象 Session
        String mailservertype=ResourceBundle.getBundle("mailserverInfo").getString("mailservertype");
        String mailserver=ResourceBundle.getBundle("mailserverInfo").getString("mailserver");
        final String mailuser=ResourceBundle.getBundle("mailserverInfo").getString("mailuser");
        final String mailpwd=ResourceBundle.getBundle("mailserverInfo").getString("mailpwd");
        final String mailsender=ResourceBundle.getBundle("mailserverInfo").getString("mailsender");
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", mailservertype);
		props.setProperty("mail.host", mailserver);
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailuser, mailpwd);
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		message.setFrom(new InternetAddress(mailsender)); // 设置发送者

		message.setRecipient(RecipientType.TO, new InternetAddress(email)); // 设置发送方式与接收者

		message.setSubject("用户激活");
		// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
}