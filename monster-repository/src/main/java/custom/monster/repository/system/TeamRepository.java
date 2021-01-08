package custom.monster.repository.system;


import custom.monster.entity.system.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
 Team findOneByName(String name);
}
