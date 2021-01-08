package custom.monster.server.controller;

import cn.hutool.core.date.DateUtil;

import cn.hutool.json.JSONObject;
import custom.monster.entity.cluster.HdfsSummary;
import custom.monster.entity.cluster.QueueMetrics;
import custom.monster.entity.cluster.YarnSummary;
import custom.monster.server.BaseController;
import custom.monster.server.schedule.YarnStatusCache;
import custom.monster.server.service.MonitorService;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/naga/v1/monitor")
@CrossOrigin
public class MonitorController extends BaseController {

    @Autowired
    MonitorService monitorService;

    @GetMapping(value = "storage")
    public Object getHdfSummary(){
        return getResult(monitorService.findHdfsSummary(DateUtil.toIntSecond(new Date())));
    }
}
