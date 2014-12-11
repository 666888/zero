package deep.zero.svc;

import deep.zero.bean.ZEntity;

public interface EntitySvc {
	ZEntity getOne(Long id);
	void freezen(Long id);
	
}
