package deep.zero.svc;

import java.util.List;

import deep.zero.bean.Balance;

/*
 * 账户余额类
 * 此类用以记录玩家的存取款记录，及最新的balane
 * 需要实现的功能包括：
 * 1.查询存过款的记录
 * 2.查询没有存过款的记录
 * 3.查询提过款的记录
 * 4.查询
 */
public interface BalanceSvc  {
	//查询存过款的记录
	List<Balance> getDisposted();
	//查询没有任何存款记录
	List<Balance> getCleanPlayer();
	//查询提过款的记录
	List<Balance> getWithdrewed();
}
