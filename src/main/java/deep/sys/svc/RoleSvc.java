package deep.sys.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deep.sys.bean.Role;

@Service
public class RoleSvc implements IRoleSvc{
	@Autowired
	private RoleRepo roleRepo;

	public void save(List<Role> role) {
		// TODO Auto-generated method stub		
		roleRepo.save(role);		
	}
	
}
