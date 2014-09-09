package deep.zero.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import deep.zero.bean.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{
	
	@Query(value="select p from Account p where p.playerId =?1 ")
	List<Account> getAccountByPlayer(Long playerId);

	@Query(value="select p from Account p where p.playerId =?1 AND p.name = ?2 ")
	Account getAccountByPlayerIdAndName(Long playId, Long name);
//	@Modifying
//	@Query(value="update Account a set a. where p.playerId =?1 AND p.name = ?2 ")
//	void updateAccount(Account account);

}
