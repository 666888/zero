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
	private int agentid;
	private String name;
	public int getAgentid() {
		return agentid;
	}
	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
