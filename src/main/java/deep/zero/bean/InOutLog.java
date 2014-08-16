package deep.zero.bean;

import java.math.BigDecimal;
import java.util.Date;

import deep.sys.bean.User;

/**
 * 中心钱包转款记录表
 * @author Administrator
 *
 */
public class InOutLog {
	//转款时间
	private	Date logTime;
	//转款金额
	private BigDecimal	amount;
	private User		user;
	//出入标志
	private Boolean	io;
	//目标或者来源
	private String 	opp;
}
