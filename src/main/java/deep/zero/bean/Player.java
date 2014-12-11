package deep.zero.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

import deep.bean.AbstractEntity;

/**
 * 玩家类，用以记录玩家信息，当前为了实现方便将玩家类和玩家的账号类写在一起
 * 在稳定版本中可能要将两个类分开
 * @author kevin
 *
 */
@Entity
@Table(name="z_player")
public class Player extends ZEntity{

	
	//密码
	private String password;
	
	private String regIP;
	//银行账号
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name="player_id")//在account表增加一个外键列来实现一对多的单向关联
//	private Set<Account> accounts=new HashSet<Account>();
	
	//电话
	private String phone;
	
	//邮箱
	private String email;
	

	public String getRegIP() {
		return regIP;
	}


	public void setRegIP(String regIP) {
		this.regIP = regIP;
	}




	public String getExtendURL() {
		return extendURL;
	}


	public void setExtendURL(String extendURL) {
		this.extendURL = extendURL;
	}
	//推广网址
	private String extendURL;
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	//性别
	@Enumerated(EnumType.ORDINAL) @Column(length=1,nullable=false)
	private Gender gender = Gender.Male;
	
	//备注
	@Basic(fetch=FetchType.LAZY)
	private String remark;
	
	
	//注册时间
	@Temporal(TemporalType.TIMESTAMP) @Column(nullable=false)
	private Date regTime;
	
	//	积分
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "player")//主Pojo这方的设置比较简单，只要设置好级联和映射到从Pojo的外键就可以了。    
	private Point point;
	
	private Long agentid;
	
	public Player(){	
	}
	
	
	public Long getAgentid() {
		return agentid;
	}
	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}
	public Point getPoint() {
		return point;
	}
	public void setPoint(Point point) {
		this.point = point;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	
}
