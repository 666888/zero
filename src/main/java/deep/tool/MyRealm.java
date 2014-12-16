package deep.tool;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import deep.sys.bean.Permission;
import deep.sys.bean.Role;
import deep.sys.bean.User;
import deep.sys.svc.UserRepo;

public class MyRealm extends AuthorizingRealm {
	@Autowired
	private UserRepo userRepo;

	/*
	 * 授权
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache
	 * .shiro.subject.PrincipalCollection)
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String code = (String)principals.fromRealm(this.getName()).iterator().next();
		//Long id = (Long)principals.fromRealm(this.getName()).iterator().next();
		List<String> roles = new ArrayList<String>();
		List<String> permissions = new ArrayList<String>();
		
		List<User> list = userRepo.getByCode(code);
		if(list.size() != 0){
		    User user = list.get(0);
		    if(user != null){
		    	if(user.getRoles() != null && user.getRoles().size() > 0){
		    		for(Role role:user.getRoles()){
		    			System.out.println(user.getCode()+"角色："+role.getName());
		    			roles.add(role.getName());
		    			System.out.println(user.getCode()+"权限："+role.getPermissions());
		    			if(role.getPermissions() != null && role.getPermissions().size() > 0){
		    				for(Permission permission:role.getPermissions()){
		    					System.out.println(user.getCode()+"权限："+permission.getRealm());
		    					permissions.add(permission.getRealm());
		    				}
		    			}
		    		}
		    	}
		    	
		    }
		}
		else{  
			throw new AuthorizationException();  
		} 
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.addRoles(roles);
		info.addStringPermissions(permissions);
		return info;
	}

	/*
	 * 验证
	 * 
	 * @see
	 * org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org
	 * .apache.shiro.authc.AuthenticationToken)
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken toke = (UsernamePasswordToken) token;
		List<User> user = userRepo.getByCode(toke.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user.get(0).getCode(), user
					.get(0).getPassword(), getName());
		} 
		else{
			return null;
		}
	}

}