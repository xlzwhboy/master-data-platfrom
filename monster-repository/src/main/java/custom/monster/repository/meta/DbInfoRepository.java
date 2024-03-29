package custom.monster.repository.meta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DbInfoRepository extends JpaRepository<DbInfo,Long> {
    DbInfo findByName(String name);
    List<DbInfo> findByProjectName(String name);
    List<DbInfo> findByProjectId(Long id);
}
