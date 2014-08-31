package deep.zero.svc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import deep.zero.bean.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {
	@Query(value="select p from Player p where p.nickname =?1 ")
	public Player getByAccount(String nickname);
	
	@Query(value="select case when count(p)>0 then true else false end  from Player p where p.nickname=?1 and p.password=?2")
	public boolean isExistPlayer(String nickname,String password);
}