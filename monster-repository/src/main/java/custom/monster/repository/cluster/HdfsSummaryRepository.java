package custom.monster.repository.cluster;

import custom.monster.entity.cluster.HdfsSummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HdfsSummaryRepository extends JpaRepository<HdfsSummary,Long> {
    //ThanEqual:小于等于,后面默认是一个传入的参数
    HdfsSummary findTop1ByIsTrashFalseAndCreateTimeLessThanEqualOrderByCreateTimeDesc(Integer selectTime);

    List<HdfsSummary> findByIsTrashFalseAndCreateTimeBetweenOrderByCreateTimeAsc(Integer startTime,Integer endTime);
}
