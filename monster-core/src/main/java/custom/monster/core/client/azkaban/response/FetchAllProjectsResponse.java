package custom.monster.core.client.azkaban.response;


import custom.monster.core.client.azkaban.model.Project;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FetchAllProjectsResponse extends BaseResponse {
    private List<Project> projects;
}
