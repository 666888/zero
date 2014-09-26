package deep.zero.repo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import deep.svc.AddRepository;
import deep.zero.bean.Balance;
@Repository
public interface BalanceRepo extends AddRepository<Balance,Long>{
//	@Query(value="select top(1) b from  Balance b where b.userId =?1 order by id desc")
//	public Balance findLast(String userId);
	
	@Query(value="select  b from  Balance b where b.playerId =?1 order by id desc")
	List<Balance>  findLastBalance(Long userId,Pageable pagable); 

	@Query(value="select  b from  Balance b where b.playerId =?1 order by id desc")
	List<Balance>  findBalanceByPlayerId(Long playerId); 
	
	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.repository.CrudRepository#findAll()
	 */
	List<Balance> findAll();
//	查找玩家游戏账户
	@Query(value="select  sum(b.recharge)-sum(b.rolloff) from  Balance b where b.playerId =?1 and b.accId=?2 ")
	BigDecimal freeAccount(Long playerId,Long accId);
	
//	@Query(value="select  sum(b.add)-sum(b.rolloff) from  Balance b where b.playerId =?1 and b.accId=?2")
//	BigDecimal GAccount(Long playerId, Long accId);
//	查找玩家主账户
	@Query(value="select  sum(b.recharge)-sum(b.rolloff) from  Balance b where b.playerId =?1 ")
	BigDecimal ALLAcount(Long playerId);
//	最近一周
	@Query(value="select  b from  Balance b where b.playerId =?1 and b.transferTime >?2 and b.transferTime<3 order by b.transferTime desc")
	List<Balance>  findFreeBalanceByPlayerId(Long accId,String weekStartTime,String weekEndTime); 
	
}

