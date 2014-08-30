package deep.zero.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 游戏类用以描述游戏信息，主要用以在客户化时定义后台接入的游戏
 * 
 */
@Entity
@Table(name="p_game")
public class Game {
	//数据id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	//游戏的名称
	private String name;
	//提供商的名称
	private String vendorName;
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
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	
}
