package deep.zero.svc;

import deep.zero.bean.Agent;
import deep.zero.bean.Player;


public interface LoginSvc {
	public boolean validate(Player player);
	public boolean agentValidate(Agent agent);
}
