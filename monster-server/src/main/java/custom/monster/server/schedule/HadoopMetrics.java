package custom.monster.server.schedule;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 封装一个hadoop的jmx页面json数据的model
 */
@Getter
@Setter
public class HadoopMetrics{
    List<Map<String,Object>> beans = new ArrayList<>();

    //获取数据
    public Object getMetricsValue(String name){
        if (beans.isEmpty()){
            return null;
        }
        //get(0)获取到list里面的map.通过key到map中查出val
        return beans.get(0).getOrDefault(name, null);

    }
}
