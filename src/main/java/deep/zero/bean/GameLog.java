package deep.zero.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 记录玩家的游戏日志，包括登录到网站，退出网站，
 * 进入到游戏A，退出一个游戏,游戏中有关转账的的功
 * 能在余额对象中描述，日志在这个地方来记录。
 * 
 */
@Entity
@Table(name="p_gameLog")
public class GameLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//玩家
//	@JoinColumn(name = "playerId", referencedColumnName = "id")
//	@ManyToOne
//	private Player playerId;
	private Long playerId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPlayerId() {
		return playerId;
	}
	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}
	public Long getGameId() {
		return gameId;
	}
	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}
	public Date getEvtTime() {
		return evtTime;
	}
	public void setEvtTime(Date evtTime) {
		this.evtTime = evtTime;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	//目标游戏的名称
//	private Game game;
	private Long gameId;
	//事件的时间
	private Date evtTime;
	//玩家的ip
	private String ipAddress;
	//事件的描述
	private String event;

}
