package deep.tool;

import org.springframework.beans.factory.annotation.Autowired;

import deep.sys.bean.User;
import deep.sys.svc.UserSvc;
import deep.zero.bean.Player;
import deep.zero.svc.PlayerSvc;

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
	
	public static void init(PlayerSvc ps){
		
		
		Player player = new Player();
		player.setCode("root");
		player.setPassword("555555");
		player.setNickname("player");
		player.setUserName("player");
		ps.addPlayer(player);
		
	}
}
