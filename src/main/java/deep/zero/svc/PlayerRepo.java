package deep.zero.svc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import deep.zero.bean.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {
	@Query(value="select o from Player o where o.nickname =?1 ")
	public Player getByAccount(String username);
	
	@Query(value="select case when count(o)>0 then true else false end  from Player o where o.nickname=?1 and o.password=?2")
	public boolean isExistUser(String nickname,String password);
}