package custom.master.server.service.Impl;


import custom.master.entity.cluster.HdfsSummary;
import custom.master.entity.cluster.QueueMetrics;
import custom.master.entity.cluster.YarnSummary;
import custom.master.repository.cluster.HdfsSummaryRepository;
import custom.master.repository.cluster.QueueMetricsRepository;
import custom.master.repository.cluster.YarnSummaryRepository;
import custom.master.server.service.MonitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Resource
    HdfsSummaryRepository hdfsSummaryRepository;
    @Resource
    YarnSummaryRepository yarnSummaryRepository;
    @Resource
    QueueMetricsRepository queueMetricsRepository;

    @Override
    public void addHdfsSummary(HdfsSummary hdfsSummary) {
        hdfsSummaryRepository.save(hdfsSummary);
    }

    @Override
    public void addYarnSummary(YarnSummary yarnSummary) {
        yarnSummaryRepository.save(yarnSummary);
    }

    @Override
    public void addQueueMetrics(List<QueueMetrics> queueMetrics) {
        queueMetricsRepository.saveAll(queueMetrics);
    }

    @Override
    public HdfsSummary findHdfsSummary(int selectTime) {
        return hdfsSummaryRepository.findTop1ByIsTrashFalseAndCreateTimeLessThanEqualOrderByCreateTimeDesc(selectTime);
    }

    @Override
    public YarnSummary findYarnSummary(int selectTime) {
        return yarnSummaryRepository.findTop1ByIsTrashFalseAndCreateTimeLessThanEqualOrderByCreateTimeDesc(selectTime);
    }

    @Override
    public List<QueueMetrics> findQueueMetrics(int selectTime) {
        return queueMetricsRepository.findByCreateTime(selectTime);
    }

    @Override
    public List<HdfsSummary> findHdfsSummaryBetween(int startTime, int endTime) {
        return hdfsSummaryRepository.findByIsTrashFalseAndCreateTimeBetweenOrderByCreateTimeAsc(startTime,endTime);
    }

    @Override
    public List<YarnSummary> findYarnSummaryBetween(int startTime, int endTime) {
        return yarnSummaryRepository.findByIsTrashFalseAndCreateTimeBetweenOrderByCreateTimeAsc(startTime,endTime);
    }
}
