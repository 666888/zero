package deep.zero.svc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deep.zero.bean.Player;

@Service("LoginSvc")
public class LoginSvcImpl implements LoginSvc{
	
	@Autowired
	private PlayerSvcImpl svc;
	
	public boolean validate(Player player){
		try{	
			return svc.isExistPlayer(player.getCode(),player.getPassword());
		}catch(Exception e){
			System.out.println("validate exception:"+e.getStackTrace());
			return false;
		}
	}
}
