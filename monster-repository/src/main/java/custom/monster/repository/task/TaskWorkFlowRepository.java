package custom.monster.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskWorkFlowRepository extends JpaRepository<TaskWorkFlow, String> {

  TaskWorkFlow findOneByName(String name);
}
