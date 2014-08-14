package deep.sys.svc;

import deep.sys.bean.User;


public interface IUserSvc {
	User getByAccount(String username);
}
