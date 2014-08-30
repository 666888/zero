package deep.zero.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 此类用以描述奖金信息,当有奖金发放时，会产生一个此类的对象，
 * 也就是说在数据库中会产生一条记录。
 * 
 * 这个类需要做完全属性的查询。
 * @author kevin
 *
 */
@Entity
@Table(name="p_bonus")
public class Bonus {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//奖金的日期
	private Date date;
	//奖金来源
	private String src;
	//奖金的类型：自动和手动两种
	private String type;
	//奖金的数额
	private BigDecimal amount;
	//奖金的状态：Waiting  Accepted Decilined
	private String status;
	
}
