package deep.zero.svc;

import java.util.Date;
import java.util.List;

import deep.zero.bean.Player;
/**
 * 用户服务用以完成玩家的增（注册）删（系统不提供）改 查
 * 1.玩家新增：在用户注册是完成的，注册一个玩家就增加了一个玩家
 * 2.玩家的删除：玩家在系统中不能被删除，只能被冻结
 * 3.玩家的修改：玩家可以修改自己的密码，另外在注册时玩家提提供
 * 	的信息是不完整的，需要在提款时加以补充
 * 4.玩家的查询：主要包括玩家全属性查询及相关对象的查询
 *  
 *  全属性的查询是指通过玩家的任一属性或者属性组合进行查询
 *  1）以昵称查询用户
 *  2）以注册时间查询，包括以最近周 月 季 以及指定的时间段查询
 *  3）冻结的玩家
 *  
 *  关联对象的查询是指通过玩家关联对象查询玩家
 *  1）存过款的玩家(has desposited)
 *  2）未存过款的玩家
 *  
 * @author kevin
 *
 */
public interface PlayerSvc{
	//通过玩家的code查询
	Player getByAccount(String code);
	//依注册周查询
	List<Player> getPlayerByRegWeek();
	//依注册月查询
	List<Player> getPlayerByRegMonth();
	//依注册季度查询
	List<Player> getPlayerByRegQuarter();
	//依照一定的时间段查询
	List<Player> getPlayerByDt(Date dStart,Date dEnd);
	//查询冻结玩家
	List<Player> getFreezenPlayer();
	//查询没有存过款的玩家
//	List<Player> getNoDepositedPlayer();
}
