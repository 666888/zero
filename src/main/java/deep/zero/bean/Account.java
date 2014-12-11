package deep.zero.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

import deep.bean.AbstractEntity;

@Entity
@Table(name="p_account")
public class Account extends AbstractEntity{
	
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
	public Long getName() {
		return name;
	}
	public void setName(Long name) {
		this.name = name;
	}
	
}
