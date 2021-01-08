package custom.monster.repository.system;


import custom.monster.entity.system.PrivilegeType;
import custom.monster.entity.system.SystemPrivilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPrivilegeRepository extends JpaRepository<SystemPrivilege, Long> {
  SystemPrivilege findOneByTeamAndPrivilegeType(String team, PrivilegeType privilegeType);

}
