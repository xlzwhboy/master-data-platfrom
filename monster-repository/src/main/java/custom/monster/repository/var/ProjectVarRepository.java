package custom.monster.repository.var;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectVarRepository extends JpaRepository<ProjectVar, Long> {
    ProjectVar findByProjectNameAndName(String projectName, String name);
    List<ProjectVar> findByBindTaskNameAndBindJobName(String taskName, String jobName);
}
