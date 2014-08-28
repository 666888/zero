package deep.sys.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Permission implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	private String realm;
	@ManyToMany(mappedBy = "permissions",fetch=FetchType.EAGER)
	private Set<Role> roles;
	
	public Permission(){
		
	}
	public Permission(String realm){
		this.realm = realm;
	}
    public Permission(String realm,Set<Role> roles){
		this.realm = realm;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRealm() {
		return realm;
	}
	public void setRealm(String realm) {
		this.realm = realm;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
}
