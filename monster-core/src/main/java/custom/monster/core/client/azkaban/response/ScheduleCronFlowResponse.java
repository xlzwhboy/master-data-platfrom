package custom.monster.core.client.azkaban.response;

import lombok.Data;

@Data
public class ScheduleCronFlowResponse extends BaseResponse {
    private String scheduleId;
}
