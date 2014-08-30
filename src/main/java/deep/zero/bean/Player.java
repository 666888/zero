package deep.zero.bean;

import java.util.Date;
import java.util.List;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
