package deep.zero.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import deep.zero.bean.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {
	@Query(value="select p  from Player p where p.code =  ?1 ")
	public Player getByCode(String code);
	
	@Query(value="select p  from Player p where p.abbrName =  ?1 ")
	public Player getByAbbrName(String abbrName);
	//	是否存在玩家
	@Query(value="select case when count(p)>0 then true else false end  from Player p where p.code=?1 and p.password=?2")
	public boolean validate(String code,String password);
	//	获取几周注册的玩家
	@Query(value="select p  from Player p where p.regTime between ?1 and ?2 ")
	public List<Player> getPlayerByRegWeek(Date startTime, Date endTime);
	//获取几个月注册的玩家
	@Query(value="select p  from Player p where p.regTime between ?1 and ?2 ")
	public List<Player> getPlayerByRegMonth(Date startTime, Date endTime);
	//季度注册的玩家
	@Query(value="select p  from Player p where p.regTime between ?1 and ?2 ")
	public List<Player> getPlayerByRegQuarter(Date startTime, Date endTime);
	//按时间查询
	@Query(value="select p  from Player p where p.regTime between ?1 and ?2 ")
	public List<Player> getPlayerByDt(Date dStart, Date dEnd);
	//查询冻结玩家
	@Query(value="select p  from Player p where p.freezen = true ")	
	public List<Player> getFreezenPlayer();
	
	@Modifying
	@Query(value="update Player p set p.freezen=true where p.id=?1")
	public void setFreezen(Long id);
	
//	@Query(value="select p  from Player p where p.accounts is null ")	
//	public List<Player> getNoDepositedPlayer();
}
