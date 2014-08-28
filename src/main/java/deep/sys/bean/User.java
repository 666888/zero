package deep.sys.bean;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String code;
	private String username;
	private String password;
	private String phone;
	private String remark;
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
    @JoinTable(name = "role_user")
	private Set<Role> roles;
	
	
	/** getXXX方法上的注解是spring MVC的验证注解，在action中调用 **/
	public User(){
		
	}
	public User(String username,String code,String password){
		this.username =username;
		this.password = password;
		this.code = code;
	}
	
	public User(String code, String userName, String password,Set<Role> roles) {
		this.code = code;
		this.username = userName;
		this.password = password;
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@NotEmpty(message = "编码不能为空")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@NotEmpty(message = "用户名不能为空")
	public String getUserName(){
		return this.username;
	}
	public void setUserName(String username){
		this.username = username;
	}	
	@Size(min = 6, max=8, message="密码长度在6位以上")
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString(){
		return username+"#"+password;
	}
}