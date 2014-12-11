package deep.zero.bean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

import deep.bean.*;
@MappedSuperclass
public class ZEntity extends deep.bean.AbstractEntity{
	//编码 
	@Column(length=20,nullable=false)
	private String code;
	//简称
	@Column(length=50)
	private String abbrName;
	//名称
	//@Transient
	private String name;
	
	private boolean freezen;
	
	public boolean getFreezen() {
		return freezen;
	}
	public void setFreezen(boolean freezen) {
		this.freezen = freezen;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getAbbrName() {
		return abbrName;
	}
	public void setAbbrName(String abbrName) {
		this.abbrName = abbrName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
