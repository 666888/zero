package deep.zero.bean;

import java.math.BigDecimal;
import java.util.Date;

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
	private Long playerId;
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
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Date getTransferTime() {
		return transferTime;
	}
	public void setTransferTime(Date transferTime) {
		this.transferTime = transferTime;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Boolean getIo() {
		return io;
	}
	public void setIo(Boolean io) {
		this.io = io;
	}
	public String getOpp() {
		return opp;
	}
	public void setOpp(String opp) {
		this.opp = opp;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;  
	private BigDecimal	balance;
	//转款时间
	private	Date transferTime;
	//转款金额
	private BigDecimal	amount;
	//备注
	private String	remark;
	//出入标志
	private Boolean	io;
	//目标或者来源
	private String 	opp;
}
