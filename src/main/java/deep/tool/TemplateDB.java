package deep.tool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import deep.sys.bean.Permission;
import deep.sys.bean.Role;
import deep.sys.bean.User;
import deep.sys.svc.IPermissionSvc;
import deep.sys.svc.IRoleSvc;
import deep.sys.svc.PermissionRepo;
import deep.sys.svc.PermissionSvc;
import deep.sys.svc.RoleSvc;
import deep.sys.svc.UserSvc;
import deep.zero.bean.Player;
import deep.zero.svc.PlayerSvc;

/**
 * 此类用以初始化数据库
 * @author Administrator
 *
 */
public class TemplateDB {
	
	
	public static void init(UserSvc svc,RoleSvc rs,PermissionSvc ps){	
		List<User> u  = new ArrayList<User>();
		List<Role> r  = new ArrayList<Role>();
		List<Permission> p  = new ArrayList<Permission>();
		
		Set<User> users1 = new HashSet<User>();
		Set<User> users2 = new HashSet<User>();
		Set<Role> roles1 = new HashSet<Role>();
		Set<Role> roles2 = new HashSet<Role>();
		Set<Permission> permissions1 = new HashSet<Permission>();
		Set<Permission> permissions2 = new HashSet<Permission>();
		
		Permission permission1 = new Permission("user:find");
		Permission permission2 = new Permission("user:edit");
		Permission permission3 = new Permission("user:delete");
		Role role1 = new Role("admin");
		Role role2 = new Role("user");
		Role role3 = new Role("player");
		User user1 = new User("root","root","666666");
		User user2 = new User("admin","admin","777777");
		User user3 = new User("a","a","888888");
		users1.add(user1);
		users1.add(user2);
		users2.add(user1);
		users2.add(user2);
		users2.add(user3);
		
		roles1.add(role1);
		roles1.add(role2);
		roles2.add(role1);
		roles2.add(role2);
		roles2.add(role3);
		
		permissions1.add(permission1);
		permissions1.add(permission2);
		permissions1.add(permission3);
		permissions2.add(permission2);
		permissions2.add(permission1);
		
		user1.setRoles(roles1);
		user2.setRoles(roles2);
		role1.setUsers(users1);
		role2.setUsers(users2);
		role1.setPermissions(permissions1);
		role2.setPermissions(permissions2);
		permission1.setRoles(roles1);
		permission2.setRoles(roles2);
		
		u.add(user1);
		u.add(user2);
		u.add(user3);	
		r.add(role1);
		r.add(role2);
		r.add(role3);	
		p.add(permission1);
		p.add(permission2);
		p.add(permission3);
				
		ps.save(p);
		rs.save(r);
		svc.add(u);
	}
	
	public static void init(PlayerSvc ps){		
		Player player = new Player();
		player.setCode("123456");
		player.setPassword("555555");
		player.setNickname("player");
		player.setUsername("player");
		ps.addPlayer(player);
		
	}
}
