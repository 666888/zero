package deep.zero.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 代理类用以描述系统中代理的对象
 * 
 * @author mac
 *
 */
@Entity
@Table(name="z_agent")
public class Agent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long agentid;
	//账号
	private String name;
	
	private String password;
	//真实姓名
	private String realName;
	private String phone;
	private String email;
	//推广链接
	private String extendURL;
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExtendURL() {
		return extendURL;
	}
	public void setExtendURL(String extendURL) {
		this.extendURL = extendURL;
	}
	public Long getAgentid() {
		return agentid;
	}
	public void setAgentid(Long agentid) {
		this.agentid = agentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
