package deep.zero.svc;

import deep.zero.bean.Agent;

/**
 * 
 *
 */
public interface AgentSvc{
	//通过代理账号查询
	Agent getAgentByName(String name);
	//
	Agent getAgentByAgentid(Long id);
	//
	boolean isExistAgent(String name, String password);
	//新增
	void addAgent(Agent agent);
}
