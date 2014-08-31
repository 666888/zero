package deep.zero.svc;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deep.zero.bean.Player;
import deep.zero.repo.PlayerRepo;



@Service
@Transactional(readOnly=true)
public class PlayerSvcImpl implements PlayerSvc {

	@Autowired
	private PlayerRepo pr;
		
	@Transactional
	public Player addPlayer(Player p){
		return pr.saveAndFlush(p);
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

	@Override
	public List<Player> getPlayerByRegWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayerByRegMonth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayerByRegQuarter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getPlayerByDt(Date dStart, Date dEnd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getFreezenPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getNoDepositedPlayer() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
