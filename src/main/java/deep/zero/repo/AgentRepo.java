package deep.zero.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import deep.zero.bean.Agent;


public interface AgentRepo extends JpaRepository<Agent, Long>{
	//获得代理账户(Id)
	Agent getAgentByAgentid(Long id);
	//获得代理账户(name)
	Agent getAgentByName(String name);
	//验证agent
	@Query(value="select case when count(a)>0 then true else false end  from Agent a where a.name=?1 and a.password=?2")
	boolean isExistAgent(String name, String password);
	
}
