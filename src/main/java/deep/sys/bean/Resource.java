package deep.sys.bean;

public class Resource {
	private Long	id;
	private String 	name;
	private String 	type;
	
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Resource(){}
	
	public Resource(Long id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
}
