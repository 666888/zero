package deep.zero.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deep.zero.bean.Agent;
import deep.zero.repo.AgentRepo;

@Service
//@Transactional(readOnly=true)
public class AgentSvcImpl implements AgentSvc {
	
	@Autowired
	private AgentRepo agentRepo;
	@Transactional
	public void addAgent(Agent agent){		
		agentRepo.saveAndFlush(agent);
	}

	@Transactional
	public void delPlayer(Long id){
		agentRepo.delete(id);
	}

	@Transactional
	public  Agent modiPlayer(Agent p){
		return agentRepo.saveAndFlush(p);
	}

	public Agent getAgentByName(String name){
		return agentRepo.getAgentByName(name);
	}

	public boolean isExistAgent(String name, String password) {
		// TODO Auto-generated method stub
		return agentRepo.isExistAgent(name,password);
	}

	public Agent getAgentByAgentid(Long id) {
		// TODO Auto-generated method stub
		return agentRepo.getAgentByAgentid(id);
	}
	
	
}
