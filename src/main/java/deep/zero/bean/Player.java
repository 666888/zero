package deep.zero.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 玩家类，用以记录玩家信息
 * @author Administrator
 *
 */
@Entity
@Table(name="z_player")
public class Player extends deep.sys.bean.User {

	private String nickname;
	private Boolean	sex;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	
}
