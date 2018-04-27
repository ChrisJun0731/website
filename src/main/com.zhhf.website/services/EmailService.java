package services;

import jo.MessageInfo;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Administrator on 2018/4/27.
 */
@Service
public class EmailService {

	private static final String SMTPSERVER = "smtp.qq.com";
	public static final String SMTPPORT = "465";
	public static final String ACCOUNT = "2623782110@qq.com";
	public static final String RECEIVER = "1193030047@qq.com";
	public static final String PWD = "mxowzybqospaecbd";


	public void sendMail(MessageInfo messageInfo){
		Properties props = createEmailConfig();
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true);
		try {
			MimeMessage message = createEmail(session, messageInfo);
			Transport transport = session.getTransport();
			transport.connect(SMTPSERVER, ACCOUNT, PWD);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Properties createEmailConfig(){
		Properties props = new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", SMTPSERVER);
		props.setProperty("mail.smtp.port", SMTPPORT);
		props.put("mail.smtp.ssl.socketFactory", "com.sun.mail.util.MailSSLSocketFactory");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.ssl.enable", "true");
		return props;
	}

	public MimeMessage createEmail(Session session, MessageInfo messageInfo) throws Exception{
		MimeMessage msg = new MimeMessage(session);
		InternetAddress fromAddress = new InternetAddress(ACCOUNT, "系统邮件提醒", "utf-8");
		InternetAddress recAddress = new InternetAddress(RECEIVER, "", "utf-8");
		String text = "用户姓名: " + messageInfo.getName() + "\n" +
				"用户邮箱: " + messageInfo.getEmail() + "\n" +
				"用户留言: " + messageInfo.getMessage();

		msg.setFrom(fromAddress);
		msg.setRecipient(Message.RecipientType.TO, recAddress);
		msg.setSubject("用户留言提醒", "utf-8");
		msg.setText(text);
		msg.setSentDate(new Date());
		msg.saveChanges();
		return msg;
	}

	/**
	 * 读取配置文件的信息
	 * @return
	 */
	public Properties loadConfig(){
		Properties props = new Properties();
		return null;
	}

}
