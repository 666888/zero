package deep.zero.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import deep.sys.bean.User;

/**
 * 账户余额类用以记录每个账户的余额 
 * @author kevin
 *
 */
@Entity
@Table(name="p_balance")
public class Balance {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;  
	
	private Long playerId;			
	//转入金额
	private BigDecimal	recharge = new BigDecimal(0.00);
	//转出金额
	private BigDecimal rolloff = new BigDecimal(0.00);
	//转款时间
	private	Date transferTime;
	//交易类型
	private String	transType;
	//备注
	private String	remark;
	//目标或者来源
	private Long accId;
	public Long getAccId() {
		return accId;
	}
	public void setAccId(Long accId) {
		this.accId = accId;
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
	public Date getTransferTime() {
		return transferTime;
	}
	public void setTransferTime(Date transferTime) {
		this.transferTime = transferTime;
	}
	
	public String getTransType() {
		return transType;
	}
	public void setTransType(String transType) {
		this.transType = transType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public BigDecimal getRecharge() {
		return recharge;
	}
	public void setRecharge(BigDecimal recharge) {
		this.recharge = recharge;
	}
	
	public BigDecimal getRolloff() {
		return rolloff;
	}
	public void setRolloff(BigDecimal rolloff) {
		this.rolloff = rolloff;
	}
}
