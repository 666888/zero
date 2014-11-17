package deep.zero.svc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deep.zero.bean.Agent;
import deep.zero.bean.Player;

@Service("LoginSvcImpl")
public class LoginSvcImpl implements LoginSvc{
	
	@Autowired
	private PlayerSvcImpl svc;
	
	@Autowired
	private AgentSvc agentSvc;
	//验证player
	public boolean validate(Player player){
		try{	
			return svc.isExistPlayer(player.getCode(),player.getPassword());
		}catch(Exception e){
			System.out.println("validate exception:"+e.getStackTrace());
			return false;
		}
	}
	//验证agent
	public boolean agentValidate(Agent agent){
		try{	
			return agentSvc.isExistAgent(agent.getName(),agent.getPassword());
		}catch(Exception e){
			System.out.println("validate exception:"+e.getStackTrace());
			return false;
		}
	}
}
