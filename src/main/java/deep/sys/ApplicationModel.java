package deep.sys;

import deep.sys.bean.User;

/**
 * This model class is used mainly to send the data into a single object which contains all the details
 * that is needed to be displayed on the jsp pages.
 *  
 * @author YinSin
 *
 */
public class ApplicationModel {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	} 
 
}
