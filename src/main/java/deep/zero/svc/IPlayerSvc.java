package deep.zero.svc;

import deep.zero.bean.Player;

public interface IPlayerSvc{
	Player getByAccount(String nickname);
}
