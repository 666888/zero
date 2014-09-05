package deep.zero.svc;

import java.util.List;

import deep.zero.bean.Balance;

/*
 * 账户余额类
 * 此类用以记录玩家的存取款记录，及最新的balane
 * 需要实现的功能包括：
 * 
 */
public interface BalanceSvc  {
	

//	free账户到G账户或是G账户到free账户	
	public void add(Balance fromBalance,Balance toBalance);
	
}
