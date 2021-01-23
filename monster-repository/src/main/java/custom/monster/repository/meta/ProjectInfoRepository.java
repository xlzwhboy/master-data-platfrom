package custom.monster.repository.meta;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectInfoRepository extends JpaRepository<ProjectInfo,Long> {
    ProjectInfo findByName(String name);
}
