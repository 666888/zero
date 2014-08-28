package deep.sys.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deep.sys.bean.Permission;
import deep.sys.bean.Role;

@Service
public class PermissionSvc implements IPermissionSvc{
	@Autowired
	private PermissionRepo permissionRepo;

	public void save(List<Permission> permission) {
		// TODO Auto-generated method stub
		permissionRepo.save(permission);
	}

	
}
