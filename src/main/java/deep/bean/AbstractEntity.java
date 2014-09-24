package deep.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *  Base class for entity implementations. Use a {@link Long} id.
 * 
 * @author kevin
  */

@MappedSuperclass
public class AbstractEntity  {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private  Long id;

	protected AbstractEntity(){
		this.id=null;
	}
	/**
	 * Returns the identifier of the entity.
	 * @return the id.
	 */
	public Long getId(){
		return this.id;
	}
	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj){
		if(this==obj)
			return true;
		if(this.id==null || obj==null || !(this.getClass().equals(obj.getClass())) )
		{
			return false;
		}
		AbstractEntity that  = (AbstractEntity)obj;
		return this.id.equals(that.getId());
	}
	
	/**
	 * (non-Javadoc)
	 * @see java.long.Object#hashCode
	 */
	@Override 
	public int hashCode(){
		return id==null?0:id.hashCode();
	}
}
