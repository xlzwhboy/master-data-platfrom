package custom.monster.repository.query;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedSqlRepository extends JpaRepository<SavedSql, Long> {
    List<SavedSql> findByCreator(String creator);
}
