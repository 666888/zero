package deep.zero.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deep.zero.bean.Account;
import deep.zero.bean.Player;
import deep.zero.repo.AccountRepo;

@Service
@Transactional(readOnly=true)
public class AccountSvcImpl implements AccountSvc{
	@Autowired
	private AccountRepo ar;
	
	@Transactional
	public void add(Player player,Long name) {
		Account account=new Account();
		account.setName(name);
		account.setPlayerId(player.getId());
		ar.save(account);
	}
	
}
