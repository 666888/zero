package deep.zero.svc;

import java.util.List;

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
	
//	@Transactional
//	public void add(Player player,Long name) {
//		Account account=new Account();
//		account.setName(name);
//		account.setPlayerId(player.getId());
//		ar.save(account);
//	}
//	玩家首次进入游戏创建游戏账户
	public void createAccount(Account account) {
		ar.save(account);
	}
//冻结账户
	public void freezenAccount(Long playId) {
		// TODO Auto-generated method stub
		Account account=ar.getAccountByPlayerIdAndName(playId,-1L);
		account.setIsFreezen(true);
		ar.saveAndFlush(account);
	}
//根据玩家获取账户列表
	public List<Account> getAccountByPlayer(Long playerId) {
		// TODO Auto-generated method stub
		return ar.getAccountByPlayer(playerId);
	}
	
}
