package deep.zero.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 积分类，用以记录玩家在我们系统中的消费积分功能
 * 积分会受用户级别的影响，不同的游戏不同的级别，其
 * 积分规则不同，所有此对象需要有Game对象及PlayerLevel对象。
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
	
	//
	private Game game;
	private PlayerLevel pl;

}
