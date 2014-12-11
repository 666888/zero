package deep.zero.svc;

import deep.zero.bean.Agent;



public interface AgentSvc extends EntitySvc{
	// 验证代理的合法性
	boolean validate(String code,String password);
	Agent save(Agent a);

	
}
