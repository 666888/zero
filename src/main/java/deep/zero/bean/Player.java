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

/**
 * 玩家类，用以记录玩家信息，当前为了实现方便将玩家类和玩家的账号类写在一起
 * 在稳定版本中可能要将两个类分开
 * @author kevin
 *
 */
@Entity
@Table(name="z_player")
public class Player{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Transient
	private String code;
	
	//昵称
	@Column(length=50,nullable=false)
	private String nickname;
	
	//用户的真实姓名
	private String username;
	
	//密码
	private String password;
	
	//银行账号
//	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//	@JoinColumn(name="player_id")//在account表增加一个外键列来实现一对多的单向关联
//	private Set<Account> accounts=new HashSet<Account>();
	
	//电话
	private String phone;
	
	//性别
	@Enumerated(EnumType.ORDINAL) @Column(length=1,nullable=false)
	private Gender gender = Gender.Male;
	
	//备注
	@Basic(fetch=FetchType.LAZY)
	private String remark;
	
	//是否冻结
	private Boolean freezen;
	
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
	public Boolean getFreezen() {
		return freezen;
	}
	public void setFreezen(Boolean freezen) {
		this.freezen = freezen;
	}

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@NotEmpty(message="昵称不能为空")
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
//	public Set<Account> getAccounts() {
//		return accounts;
//	}
//
//
//	public void setAccounts(Set<Account> accounts) {
//		this.accounts = accounts;
//	}


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
	//@NotEmpty(message="注册时间不能为空")
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	
}
