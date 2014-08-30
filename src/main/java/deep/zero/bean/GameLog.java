package deep.zero.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 记录玩家的游戏日志，包括登录到网站，退出网站，
 * 进入到游戏A，退出游戏Ａ,游戏中有关转账的的功
 * 能在余额对象中描述，不在这个地方来记录。
 * 
 */
@Entity
@Table(name="p_gameLog")
public class GameLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	//玩家
	private Player player;
	//目标游戏的名称
	private Game game;
	//事件的时间
	private Date evtTime;
	//玩家的ip
	private String ipAddress;
	//事件的描述
	private String event;

}
