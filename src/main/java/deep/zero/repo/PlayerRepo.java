package deep.zero.repo;

import java.util.Date;
import java.util.List;

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
	
	@Query(value="select p  from Player p where p.regTime between ?1 and ?2 ")
	public List<Player> getPlayerByRegWeek(Date startTime, Date endTime);

	@Query(value="select p  from Player p where p.regTime between ?1 and ?2 ")
	public List<Player> getPlayerByRegMonth(Date startTime, Date endTime);

	@Query(value="select p  from Player p where p.regTime between ?1 and ?2 ")
	public List<Player> getPlayerByRegQuarter(Date startTime, Date endTime);

	@Query(value="select p  from Player p where p.regTime between ?1 and ?2 ")
	public List<Player> getPlayerByDt(Date dStart, Date dEnd);
	
	@Query(value="select p  from Player p where p.freezen = true ")	
	public List<Player> getFreezenPlayer();
	
	@Query(value="select p  from Player p where p.account is null ")	
	public List<Player> getNoDepositedPlayer();
}