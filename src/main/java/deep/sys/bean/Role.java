package deep.sys.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	@ManyToMany(mappedBy = "roles",cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
	private Set<User> users;
	@ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
    @JoinTable(name = "permission_role")
	private Set<Permission> permissions;
	
	public Role(){		
		
	}
	
	public Role(String name){
		this.name = name;		
	}
	
	public Role(String name,Set<User> users,Set<Permission> permissions) {
		this.users = users;
		this.name = name;
		this.permissions = permissions;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
