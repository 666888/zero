package deep.zero.svc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * 转款类型,这是使用对象的形式来实现的，也可以使用枚举的方式来实现
 * 如果使用后一种方式，则用户不能自己定义了，这个类只作为下一个版本
 * 预留的功能，当前版本中建议使用枚举的方式来实现。
 * 主要包括：
 * 1.desposited 存款
 * 2.withdrawl	提款
 * 3.trans 		转入（主要是奖金到达一定数额后转为存款）
 * 4.manual		后台管理员增加的
 * 5.other		其它的
 */
@Entity
@Table(name="z_transType")
public class TransType {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
}
