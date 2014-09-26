package deep.zero.svc;



import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deep.sys.bean.User;
import deep.zero.bean.Balance;
import deep.zero.bean.Player;
import deep.zero.repo.BalanceRepo;


@Service
@Transactional(readOnly=true)
public class BalanceSvcImpl implements BalanceSvc{
	
	@Autowired
	private BalanceRepo br;
////	创建账户
//	public void save(Balance balance){
//		br.save(balance);
//	}
//	从银行到账户
	public void BankToAccount(Balance balance,String accountId){
//		调银联接口=========================================
		br.save(balance);
	}
	
//	free账户到G账户或是G账户到free账户
	@Transactional
	public void add(Balance fromBalance,Balance toBalance) {
		br.save(fromBalance);
		br.save(toBalance);
	}
//	账户余额
	public BigDecimal freeAccount(Long playerId,Long accId){
		return br.freeAccount(playerId,accId);
	}
////	G余额
//	public BigDecimal GAccount(Long playerId,Long accId){
//		return br.GAccount(playerId,accId);
//	}
	
//	总余额
	public BigDecimal ALLAcount(Long playerId){
		return br.ALLAcount(playerId);
	}
//	明细
	public List<Balance> getListAccount(){
		return null;
	}
//提现
	public void AccountToBank(Balance balance,String accountId) {
//		调银联接口=========================================
		br.save(balance);
	}
	//查询所有
	public List<Balance> findAll(){
		return br.findAll();
	}

	public List<Balance> findFreeBalanceByPlayerId(Long accountId,String weekStartTime, String weekEndTime) {
		return br.findFreeBalanceByPlayerId(accountId,weekStartTime,weekEndTime);
	}
}
