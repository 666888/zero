package deep.zero.svc;

import java.util.List;

import deep.zero.bean.Account;

/**
 * 此类用以描述玩家的账户信息，由于一个玩家可以有多个游戏，每个游戏都有其账户
 * 此外玩家还有一个中心账户定义为-1
 * 涉及到的业务主要有
 * 1.玩家注册完成后产生玩家中心账户
 * 2.玩家第一次进入一个游戏创建该游戏对应账户
 * 3.冻结中心账户
 * 3.通过玩家查询所有的账户
 * 
 * 所需的业务接口操作如下
 * 1.创建账户
 * 2冻结中心账户
 * 3.通过玩家查询账户列表
 * @author chenlj
 *
 */
public interface AccountSvc {
//	创建一个账户
	public void createAccount(Account account);
	
//	冻结中心账户
	public void freezenAccount(Long playId);
	
//	通过玩家查询账户列表
	public List<Account> getAccountByPlayer(Long playerId);
	 

}
