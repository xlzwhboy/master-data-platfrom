package custom.monster.core.client.azkaban.response;


import custom.monster.core.client.azkaban.model.Schedule;
import lombok.Data;

@Data
public class FetchScheduleResponse extends BaseResponse {
    private Schedule schedule;

}
