package com.lib.service;

import javax.mail.*;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailService {



      
      //  String from = "knowlibrary123@gmail.com";




	public  void sendEmail(  String to, String from ,String id , String name) {
		// TODO Auto-generated method stub
		//variable for gmail host
		String host = "smtp.gmail.com";
		
		//get the system properties
		Properties properties = System.getProperties();
		System.out.println("Properties:" + properties);
		
		//set host
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");


		
		//step1 : to get session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("knowlibrary123@gmail.com", "chjuucqizqdbyzip");
			}
			
			
		} );
		
		session.setDebug(true);
		MimeMessage m = new MimeMessage(session);
		try {
		//from email
		m.setFrom(new InternetAddress(from));
		
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		
		String subject = "Welcome to Knowledge Library";
		m.setSubject(subject);
		
		String msg = "<h1>Knowlwdge Library Mimbership ID: </h1>"
                + "<hr>"
                + "Hello <b>" + name + "</b>,<br><br>"
                + "Your registeration in Knowlwdge Library is Done Successfully."
                + "Your membership id is : <b>" + id + "</b>.";
		
		m.setText(msg);
		
		Transport.send(m);
		System.out.println("sent...");
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}

