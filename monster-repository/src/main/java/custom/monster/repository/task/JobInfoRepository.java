package custom.monster.repository.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobInfoRepository extends JpaRepository<JobInfo, String> {
  void deleteByTaskId(String taskId);

  List<JobInfo> findByTaskId(String taskId);
  List<JobInfo> findByTaskName(String taskName);

  JobInfo findByTaskNameAndName(String taskName, String name);

}
