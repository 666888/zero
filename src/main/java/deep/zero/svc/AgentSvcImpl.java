package deep.zero.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deep.zero.bean.Agent;
import deep.zero.bean.ZEntity;
import deep.zero.repo.AgentRepo;

@Service("agentSvc")
//@Transactional(readOnly=true)
public class AgentSvcImpl implements AgentSvc {
	
	@Autowired
	private AgentRepo agentRepo;
	@Transactional
	public void addAgent(Agent agent){		
		agentRepo.saveAndFlush(agent);
	}
	
	public ZEntity getOne(Long id) {
		// TODO Auto-generated method stub
		return agentRepo.getOne(id);
	}
	
	public Agent save(Agent a){
		return agentRepo.saveAndFlush(a);
	}
	
	@Transactional
	public void delPlayer(Long id){
		agentRepo.delete(id);
	}

	@Transactional
	public  Agent modiPlayer(Agent p){
		return agentRepo.saveAndFlush(p);
	}
	public boolean validate(String name, String password) {
		// TODO Auto-generated method stub
		return agentRepo.validate(name, password);
	}

	public void freezen(Long id) {
		// TODO Auto-generated method stub
		
	}

}
