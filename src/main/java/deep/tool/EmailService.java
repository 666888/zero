package deep.tool;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 邮件发送工具类
 * @author Administrator
 *
 */

public class EmailService {
	
	/**
	  * @param reply   回复地址
	  * @param to   收信人地址
	  * @param subject  邮件标题
	  * @param email   邮件正文
	  */
	 public static boolean sendHtmlEmail(String reply, String to, String subject, String email) {

	  String smtpServer = MailConstants.Email_SMTP;   // SMTP服务器名
	  String name = MailConstants.MALL_ACCOUNT;   // 邮箱登录名
	  String passWord = MailConstants.MALL_PASSWORD; // 邮箱密码
	  
	  Properties props = new Properties();
	  Session sendMailSession;
	  Transport transport;
	  sendMailSession = Session.getInstance(props);

	//  props.put("mail.transport.protocol", "smtp");
	//  props.put("mail.smtp.starttls.enable","true");
	//  props.put("mail.smtp.host", "gmail-smtp.l.google.com");
	//  props.put("mail.smtp.auth", "true");
	  
	  props.put("mail.smtp.host", smtpServer);
	  props.put("mail.smtp.port", 25);
	//  props.put("mail.smtp.port", 465);
	  props.put("mail.smtp.auth", "true");
	  
	  MimeMessage message = new MimeMessage(sendMailSession);
	  
	  try {
	   message.setFrom(new InternetAddress(reply));
	//   InternetAddress[] ias = new InternetAddress[1];
	//   ias[0] = new InternetAddress(reply);
	//   message.setReplyTo(ias);
	   InternetAddress[] address = InternetAddress.parse(to);
	   message.setRecipients(Message.RecipientType.TO, address);
	   message.setSubject(subject);
	   
	   // 设置邮件发送时间，将来要和服务器时间互转
	   Calendar clientCal = Calendar.getInstance();
	   message.setSentDate(clientCal.getTime());

	   BodyPart mdp = new MimeBodyPart();      // 新建一个存放信件内容的BodyPart对象
	   mdp.setContent(email, "text/html;charset=UTF-8");  // 给BodyPart对象设置内容和格式/编码方式
	   Multipart mp = new MimeMultipart();      // 新建一个MimeMultipart对象用来存放BodyPart对象
	   mp.addBodyPart(mdp);         // 将BodyPart加入到MimeMultipart对象中
	   message.setContent(mp);         // 把mm作为消息对象的内容

	   transport = sendMailSession.getTransport("smtp");
	   transport.connect(smtpServer, name, passWord);
	   message.saveChanges();
	   transport.sendMessage(message, message.getAllRecipients());
//	   transport.close();
	   
	   return true;
	  } catch (AddressException addressException) {
	   addressException.printStackTrace();
	   return false;
	  } catch (MessagingException messagingException) {
	   messagingException.printStackTrace();
	   return false;
	  }
	 }
	 
	 /**
	  * @param from   发信人地址
	  * @param to   收信人地址
	  * @param subject  邮件标题
	  * @param email   邮件正文
	  */
	 public static boolean sendSimpleEmail (String from, String to, String subject, String email) {
	  
	  String smtpServer = MailConstants.Email_SMTP;  // SMTP服务器名
	  try {
	   Authenticator auth = null;  	  
	   auth = new MailAuthenticator();
	   Properties props = new Properties();       // 创建properties对象
	   props.put("mail.smtp.host", smtpServer);      // 创建邮件服务器
	   props.put("mail.smtp.auth", "true");     
	   Session session = Session.getDefaultInstance(props, auth); // 取得默认的Session
//     在控制台显示Debug信息  
       session.setDebug(true); 
	   MimeMessage message = new MimeMessage(session);    // 创建一条信息，并定义发信人地址和收信人地址
	   message.setFrom(new InternetAddress(from));
	   InternetAddress[] address = InternetAddress.parse(to);
	   
	   message.setRecipients(Message.RecipientType.TO, address);
	   
	   message.setSubject(subject);    // 设定主题
	   message.setSentDate(new Date());   // 设定发送时间
	 
	   MimeBodyPart mbp1 = new MimeBodyPart();
	   mbp1.setText(email);
	   Multipart mp = new MimeMultipart();   //创建Multipart
	   mp.addBodyPart(mbp1);
	 
	   message.setContent(mp);      //添加 Multipart到Message中
//	   message.saveChanges();
	   System.out.println("正在连接服务器。。。。");  
       Transport transport = session.getTransport("smtp");  
       transport.connect(props.getProperty("mail.smtp.host"), props  
               .getProperty("username"), props.getProperty("password"));   
         
       System.out.println("正在发送邮件。。。。");  
	   Transport.send(message);     // 发送邮件
	   
	   return true;
	  } catch (AddressException addressException) {
	   return false;
	  } catch (MessagingException messagingException) {
		  messagingException.printStackTrace();
	   return false;
	  }
	 }

	    /**
	     * 判断Email格式是否正确
	     * @author 
	     * 2008.10.14
	     * @param email 判断的Email
	     * @return true or false
	     */
	     public static boolean isEmail(String email) {
	      String regex = "//w+([-+.]//w+)*@//w+([-.]//w+)*//.//w+([-.]//w+)*";
	      Pattern p = Pattern.compile(regex);
	      Matcher m = p.matcher(email);
	      return m.find(); 
	     }

	     /**
	      * 获取Email前缀（@之前的字符串）
	      * @author 
	      * 2008.10.29
	      * @param email
	      * @return @之前的字符串
	      */
	     public static String getEmailName(String email) {
	      if (email == null || email.trim().equals("")) {
	       return "";
	      } else {
	       int index = email.indexOf("@");
	       if (index == -1) {
	        return email;
	       }
	       return email.substring(0, index);
	      }
	     }
}
