package deep.zero.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * 玩家级别类：
 * 此类用以描述玩家在各个游戏中的级别信息
 * 每一个玩家可以有多个游戏，如A B C D四个游戏，对于每个游戏都有一个级别，
 * 因此这里所说的级别是指一个玩家在某个游戏中的级别，此对象同玩家及游戏对象
 * 有关联，可以用此类表示
 * 
 */
@Entity
@Table(name = "p_playerLevel")
public class PlayerLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// //玩家
	// @JoinColumn(name = "id", referencedColumnName = "id")
	// @OneToOne
	// private Player plr;
	private Long playerId;
	// 游戏
	private Long gameId;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	// private Game game;
	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	// 级别
	private int level;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// public Player getPlr() {
	// return plr;
	// }
	// public void setPlr(Player plr) {
	// this.plr = plr;
	// }
//	public Game getGame() {
//		return game;
//	}
//
//	public void setGame(Game game) {
//		this.game = game;
//	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

}
