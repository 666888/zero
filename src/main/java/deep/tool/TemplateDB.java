package deep.tool;

import deep.sys.bean.User;
import deep.sys.svc.UserSvc;

/**
 * 此类用以初始化数据库
 * @author Administrator
 *
 */
public class TemplateDB {

	public static void init(UserSvc svc){
		User usr = new User();
		usr.setCode("root");
		usr.setPassword("666666");
		usr.setUserName("Admin");
		svc.addUser(usr);
	}
}
