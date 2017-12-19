package com.angularscripts.lifecare.app.utils;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.angularscripts.lifecare.app.constants.Constants;
import com.angularscripts.lifecare.app.entity.Request;

@Component
public class EmailUtils {
	
	public void sendRequestEmail(Request request) throws Exception {
		Properties emailProperties = setEmailProperties();
		Session session = getSession(emailProperties);
		try {

			Message requestMessage = new MimeMessage(session);
			requestMessage.setFrom(new InternetAddress(request.getEmailId()));
			requestMessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(Constants.ADMIN_EMAIL_ADDRESS));
			requestMessage.setSubject("New Service Request - "+request.getRequestId());
			requestMessage.setContent("<body>"
					+ "<h4>A new customer request has arrived. Below are the request details:-</h4><br/>"
					+ "<table border='2'>"
	                + "<tr><td>Contact Person</td><td>  " + request.getContactPersonName() + "</td></tr>" 
	                + "<tr><td>Conatct No.</td><td>  " + request.getContactNumber() + "</td></tr>"
	                + "<tr><td>Email Id</td><td>  " + request.getEmailId() + "</td></tr>"
	                + "<tr><td>Service Requested</td><td>  <b>" + request.getServiceRequested() + "</b></td></tr>"
	                + "<tr><td>City </td><td> " + request.getCity() + "</td></tr>"
	                + "<tr><td>Address</td><td> " + request.getAddress() + "</td></tr>"
	                + "<tr><td>Patient Name</td><td> " + request.getPatientName() + "</td></tr>"
	                + "<tr><td>Patient Gender</td><td> " + request.getPatientGender() + "</td></tr>"
	                + "<tr><td>Patient Age</td><td> " + request.getPatientAge() + "</td></tr>"
	                + "<tr><td>Date</td><td>" + request.getDate() + "</td></tr>"
	                + "</table><br/>"
	                + "<h6>Note: This is an auto generated email.</h6>"
	                + "</body>", "text/html");

			Transport.send(requestMessage);
			System.out.println("Request email sent successfully....");
		} catch (Exception e) {
			System.out.println("Error sending request email....");
			throw e;
		}
	}
	
	
	public void sendAcknowledgementMail(Request request) throws Exception {
		Properties emailProperties = setEmailProperties();
		Session session = getSession(emailProperties);
		try {

			Message acknowledgementMessage = new MimeMessage(session);
			acknowledgementMessage.setFrom(new InternetAddress(Constants.ADMIN_EMAIL_ADDRESS));
			acknowledgementMessage.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(request.getEmailId()));
			acknowledgementMessage.setSubject("Service Request - "+request.getRequestId()+" has been created");
			MimeBodyPart acknowledgementMessageBodyPart = new MimeBodyPart();
			acknowledgementMessageBodyPart.setContent("<body>"
					+ "<p>Hello "+ StringUtils.capitalize(request.getContactPersonName())+",</p>"
					+ "<p>Thanks for contacting Life Care At Home and showing faith in us. We have received your request and we will contact you in next 3 hours. "
					+ "For more details, visit our website .</p><br/>"
					+ "Warm Regards,<br/>"
					+ "Team Life Care At Home<br/>"
					+ "<img src=\"cid:image\">"
	                + "<h6>Note: This is an acknowledgement email.</h6>"
	                + "</body>", "text/html");
			Multipart multipart = new MimeMultipart("related");
			multipart.addBodyPart(acknowledgementMessageBodyPart);
			acknowledgementMessageBodyPart = new MimeBodyPart();
		    DataSource dataSource = new FileDataSource(Constants.IMAGES_PATH);
		    acknowledgementMessageBodyPart.setDataHandler(new DataHandler(dataSource));
		    multipart.addBodyPart(acknowledgementMessageBodyPart);
		    acknowledgementMessageBodyPart.setHeader("Content-ID", "<image>");
			acknowledgementMessage.setContent(multipart);
			Transport.send(acknowledgementMessage);
			System.out.println("Acknowledgement email sent successfully....");
		} catch (Exception e) {
			System.out.println("Error sending acknowledgement email....");
			throw e;
		}
	}
	
	private Properties setEmailProperties() {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", Constants.SMTP_HOST);
		properties.put("mail.smtp.socketFactory.port", Constants.SMTP_PORT);
		properties.put("mail.smtp.socketFactory.class",
				Constants.SMTP_CLASS);
		properties.put("mail.smtp.auth", Constants.SMTP_AUTH);
		properties.put("mail.smtp.port", Constants.SMTP_PORT);
		return properties;
	}
	
	private Session getSession(Properties emailProperties) {
		return Session.getInstance(emailProperties,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(Constants.ADMIN_EMAIL_ADDRESS, Constants.ADMIN_PASSWORD);
					}
				});
	}
}
