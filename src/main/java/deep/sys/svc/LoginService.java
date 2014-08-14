package deep.sys.svc;

import deep.sys.bean.User;


public interface LoginService {
	public boolean validate(User user);
}
