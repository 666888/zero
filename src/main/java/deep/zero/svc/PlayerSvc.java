package deep.zero.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import deep.sys.bean.User;
import deep.zero.bean.Player;

@Service
@Transactional(readOnly=true)
public class PlayerSvc implements IPlayerSvc {

	@Autowired
	private PlayerRepo pr;
		
	@Transactional
	public User addUser(Player p){
		return pr.saveAndFlush(p);
	}

	@Transactional
	public void delUser(Long id){
		pr.delete(id);
	}

	@Transactional
	public  User modiUser(Player p){
		return pr.save(p);
	}

	public User get(Long id){
		return pr.findOne(id);
	}
	public List<Player> getAll(){
		return pr.findAll();
	}
	public Player getByAccount(String username) {
		return pr.getByAccount(username);
	}
	public boolean isExistUser(String nickname,String password){
		return pr.isExistUser(nickname, password);
	}
	
}
