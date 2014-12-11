package deep.zero.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import deep.zero.bean.Agent;
import deep.zero.bean.Player;
@Repository
public interface AgentRepo extends JpaRepository<Agent, Long>{
	//验证agent
	@Query(value="select case when count(a)>0 then true else false end  from Agent a where a.code=?1 and a.password=?2")
	boolean validate(String code, String password);
	
	//@Query(value="update Agent  a set a.id=?1")
	@Query(value="update Agent a set a.freezen=true where a.id=?1")
	void setFreezen(Long id);
	
	
	//@Modifying(clearAutomatically = true)
	//@Query("update RssFeedEntry feedEntry set feedEntry.read =:isRead where feedEntry.id =:entryId")
	//void markEntryAsRead(@Param("entryId") Long rssFeedEntryId, @Param("isRead") boolean isRead);
	
}
