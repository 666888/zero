package deep.zero.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 玩家类，用以记录玩家信息，
 * @author kevin
 *
 */
@Entity
@Table(name="z_player")
public class Player{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String code;
	//昵称
	private String nickname;
	//用户的真实姓名
	private String username;
	//密码
	private String password;
	//银行账号
	private String account;
	
	//电话
	private String phone;
	//性别
	private Boolean	sex;
	//备注
	private String remark;
	//是否冻结
	private Boolean freezen;
	//注册时间
	
	
	private Date regTime;
//	积分
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "player")//主Pojo这方的设置比较简单，只要设置好级联和映射到从Pojo的外键就可以了。    
	private Point point;
	
////	玩家级别
//	@OneToOne(cascade = CascadeType.ALL, mappedBy = "plr")
//	private PlayerLevel plevel;
//	
//	public PlayerLevel getPlevel() {
//		return plevel;
//	}
//	public void setPlevel(PlayerLevel plevel) {
//		this.plevel = plevel;
//	}
	private Long agentid;
	
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
	public Player(){
		
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
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
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
