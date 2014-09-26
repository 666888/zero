package deep.tool;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 用户名和密码的验证
 * 
 * @author clj
 *
 */
public class MailAuthenticator extends Authenticator{
	private String username = MailConstants.MALL_ACCOUNT;
	private String password = MailConstants.MALL_PASSWORD;

	public MailAuthenticator() {
		super();
	}

	/**
	 * 设置验证的用户名和密码
	 */
	public MailAuthenticator(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}

	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(this.username, this.password);
	}
}
