package deep.tool;

public class MailConstants {
     public static final String  Email_SMTP="smtp.163.com";
     public static final String  MALL_ACCOUNT ="Subic_Service@163.com";
     public static final String  MALL_PASSWORD="Subic123456";
     public static final String  MALL_SENDER_ALIAS="来自"+Constants.WAP_NAME+"的邮件";
     
     //邮件类型
     public static final String   MALL_TYPE_FINDPWD="1";//找回密码
     public static final String   MALL_TYPE_ACTIVE= "2";//激活注册
     public static final String   MALL_TYPE_ACTIVE_UPDATE= "3";//修改邮箱
     //END
     
   
     public static final String  EMAIL_FINDPASSWORD_URL          = Constants.SERVER_INDEX_URL+"/email/find/findpassword/%s";
     public static final String  EMAIL_FINDPASSWORD_SOURCE_URL   = "/email/find/findpassword/";
     public static final String  EMAIL_FINDPASSWORD_REDIRECT_URL ="/mobilemall/reset_pw.jsp?code=";
     public static final String EMAIL_END_DEFAULT_WORD = "<br/>如果点击以上链接没有反应，请将该网址复制并粘贴到新的浏览器窗口中。<br/>" +
		"如果您并未发送过此请求邮件，则可能是因为其他用户误输入了您的电子邮件地址而使您收到这封邮件，那么您可以放心的忽略此邮件，无需进一步采取任何操作。<br/>" +
		Constants.WEB_NAME+"祝您生活愉快<br/>" ;
     
     public static final String EMAIL_ACTIVE_DEFAULT_WORD = "尊敬的%s<br/>您好，感谢您使用"+Constants.WEB_NAME+"，" +
		"您已经在"+Constants.WEB_NAME+"注册成功，请使用用户ID(%s)或邮箱(%s)登录，请点击以下链接激活（链接48小时内有效）<br/><a href=\"%s\">%s</a><br/>" +
		""+Constants.WEB_NAME+"，开始您的梦想之旅。<br/>" + EMAIL_END_DEFAULT_WORD;

     public static final String NEW_EMAIL_ACTIVE_DEFAULT_WORD = "尊敬的%s<br/>您好，感谢您使用"+Constants.WEB_NAME+"，" +
		"您已经修改你的邮箱，该邮件为邮箱激活邮件，请点击链接激活您的邮箱（链接48小时内有效）。<br/><a href=\"%s\">%s</a><br/>" +
		  EMAIL_END_DEFAULT_WORD; 
     
     public static final String EMAIL_ACTIVE_DEFAULT_TITLE = ""+Constants.WEB_NAME+"账号激活邮件";
     
     public static final String EMAIL_FINDPASSWORD_DEFAULT_TITLE = ""+Constants.WEB_NAME+"密码找回邮件";
     
     public static final String EMAIL_FINDPASSWORD_DEFAULT_WORD = "尊敬的%s<br/>您好，欢迎使用"+Constants.WEB_NAME+"找回密码功能。" +
     		"请点击以下链接重置您的密码（链接24小时内有效）<br/><a href=\"%s\">%s</a><br/>" + EMAIL_END_DEFAULT_WORD;
     
     
     public static final String  EMAIL_ACTIVE_EMAIL_URL    = Constants.SERVER_INDEX_URL+"/email/active/active_email/%s";
     public static final String  EMAIL_ACTIVE_SOURCE_URL   = "/email/active/active_email/";
     public static final String  EMAIL_ACTIVE_REDIRECT_URL = "/email/active/email_active.html?code=";
     
     public  static  final int EMAIL_RESULT_CODE_1=1;
     public  static  final int EMAIL_RESULT_CODE_2=2;
     public  static  final int EMAIL_RESULT_CODE_3=3;
     public  static  final int EMAIL_RESULT_CODE_0=0;
}
