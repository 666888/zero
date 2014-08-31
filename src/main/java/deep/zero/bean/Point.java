package deep.zero.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 积分类，用以记录玩家在我们系统中的消费积分功能
 * 积分会受用户级别的影响，不同的游戏不同的级别，其
 * 积分规则不同，所有此对象需要有PlayerLevel对象。
 * @author mac
 *
 */
@Entity
@Table(name="z_point")
public class Point {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Date evtTime;
	//有关此积分的说明
	private String descrip;
	//积分分值	
	private long score;
	//玩家
	@JoinColumn(name = "id",  referencedColumnName = "id")//设置从方指向主方的关联外键，这个id其实是表Player的主键    
	@OneToOne
	private Player player;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getEvtTime() {
		return evtTime;
	}
	public void setEvtTime(Date evtTime) {
		this.evtTime = evtTime;
	}
	public String getDescrip() {
		return descrip;
	}
	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}
	public long getScore() {
		return score;
	}
	public void setScore(long score) {
		this.score = score;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}


}
