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
			return svc.isExistPlayer(player.getNickname(),player.getPassword());
		}catch(Exception e){
			System.out.println("validate exception:"+e.getStackTrace());
			return false;
		}
	}

	/**
	public boolean validate(User user) {
		String SQL ="SELECT * FROM sys_users WHERE userName = '"+user.getUserName()+"' and password = '"+user.getPassword()+"';";
		System.out.println("SQL : "+SQL);
		Statement stmt = null;
		try{
			stmt = ConnectionDAO.getStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			if(null != rs && rs.next()){
				return true;
			}
			else
			{
				return false;
			}
		}catch(SQLException e){
			System.out.println("SQL Exception : "+e.getMessage());
			return false;
		}
	}
	**/
}
