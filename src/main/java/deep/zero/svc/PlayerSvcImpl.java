package deep.zero.svc;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deep.tool.DateUtils;
import deep.zero.bean.Account;
import deep.zero.bean.Player;
import deep.zero.repo.AccountRepo;
import deep.zero.repo.PlayerRepo;



@Service("playerSvcImpl")
@Transactional(readOnly=true)
public class PlayerSvcImpl implements PlayerSvc {

	@Autowired
	private PlayerRepo pr;
	@Autowired
	private AccountRepo ar;
		
	@Transactional
	public Player addPlayer(Player p){
		Account account=new Account();
		account.setName(-1L);//玩家主账户识别为-1，其他游戏账户为gameId
		pr.saveAndFlush(p);
		account.setPlayerId(p.getId());
		ar.save(account);
		return p;
	}

	@Transactional
	public void delPlayer(Long id){
		pr.delete(id);
	}

	@Transactional
	public  Player modiPlayer(Player p){
		return pr.save(p);
	}

	public Player get(Long id){
		return pr.findOne(id);
	}
	public List<Player> getAll(){
		return pr.findAll();
	}
	public Player getByAccount(String nickname) {
		return pr.getByAccount(nickname);
	}
	public boolean isExistPlayer(String nickname,String password){
		return pr.isExistPlayer(nickname, password);
	}

	public List<Player> getPlayerByRegWeek() {
		Date startTime=DateUtils.weekStartTime();
		Date endTime=DateUtils.weekEndTime();
		return pr.getPlayerByRegWeek(startTime,endTime);
	}

	public List<Player> getPlayerByRegMonth() {
		Date startTime=DateUtils.getCurrentMonthStartTime();
		Date endTime=DateUtils.getCurrentMonthEndTime();
		return pr.getPlayerByRegMonth(startTime,endTime);
	}

	public List<Player> getPlayerByRegQuarter() {
		Date startTime=DateUtils.getCurrentQuarterStartTime();
		Date endTime=DateUtils.getCurrentQuarterEndTime();
		return pr.getPlayerByRegQuarter(startTime,endTime);
	}

	public List<Player> getPlayerByDt(Date dStart, Date dEnd) {
		return pr.getPlayerByDt(dStart,dEnd);
	}

	public List<Player> getFreezenPlayer() {
		return pr.getFreezenPlayer();
	}

//	public List<Player> getNoDepositedPlayer() {
//		return pr.getNoDepositedPlayer();
//	}

	
}
