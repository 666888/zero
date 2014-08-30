package deep.zero.svc;

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
	
}

