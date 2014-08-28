package deep.sys.svc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import deep.sys.bean.Permission;

public interface PermissionRepo extends JpaRepository<Permission, Long>{

}
