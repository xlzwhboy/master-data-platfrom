package custom.monster.repository.meta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataSourceRepository extends JpaRepository<DataSource, Long> {
    DataSource findByName(String name);

    List<DataSource> findByProjectName(String name);

    List<DataSource> findByProjectId(Long id);
}
