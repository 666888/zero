package deep.zero.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import deep.zero.bean.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
