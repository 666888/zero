package deep.zero.svc;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deep.sys.bean.User;
import deep.zero.bean.Balance;
import deep.zero.bean.Player;


@Service
@Transactional(readOnly=true)
public class BalanceSvcImpl implements BalanceSvc{
	
	@Autowired
	private BalanceRepo br;
	
	@Transactional
	public Balance addBalance(Balance b){
		return br.save(b);
	}
	
	public Balance get(Long id){
		return br.findOne(id);
	}
	
	public List<Balance> getAll(){
		return br.findAll();
	}
	
	public Balance findLastBalance(Long playerId){
		List<Balance> balanceList=br.findLastBalance(playerId, new PageRequest(0,1));
		if (0==balanceList.size()) {
			return null;
		}
		return balanceList.get(0);
	}
	
	public List<Balance> findBalanceByPlayerId(Long playerId){
		return br.findBalanceByPlayerId(playerId);
	}

	public List<Balance> getDisposted() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Balance> getCleanPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Balance> getWithdrewed() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
