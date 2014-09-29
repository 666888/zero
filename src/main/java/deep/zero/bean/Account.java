package deep.zero.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="p_account")
public class Account {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;//账户Id
	private Long name;//将来存放gameid 玩家进入某个游戏的账户  将-1为主账户
	private Long playerId;
	private Boolean isFreezen;
	public Boolean getIsFreezen() {
		return isFreezen;
	}
	public void setIsFreezen(Boolean isFreezen) {
		this.isFreezen = isFreezen;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getName() {
		return name;
	}
	public void setName(Long name) {
		this.name = name;
	}
	
}
