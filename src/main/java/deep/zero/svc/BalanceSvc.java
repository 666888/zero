package deep.zero.svc;

import java.math.BigDecimal;
import java.util.List;

import deep.zero.bean.Balance;

/*
 * 账户余额类
 * 此类用以记录玩家的存取款记录，及最新的balane
 * 需要实现的功能包括：
 * 
 * 
 */
public interface BalanceSvc  {
	
//	银行到账户
	public void BankToAccount(Balance balance,String accountId);
//	free账户到G账户或是G账户到free账户	
	public void add(Balance fromBalance,Balance toBalance);
	
//	账户余额
	public BigDecimal freeAccount(Long playerId,Long accId);
	
//	总余额
	public BigDecimal ALLAcount(Long playerId);
	
//	从账户到卡上
	public void AccountToBank(Balance balance,String accountId);

	//查询所有
	public List<Balance> findAll();
	
//	查询主账户信息
	public List<Balance> findFreeBalanceByPlayerId(Long accountId,
			String weekStartTime, String weekEndTime);
}
