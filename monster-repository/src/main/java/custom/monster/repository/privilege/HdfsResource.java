package custom.monster.repository.privilege;

import lombok.Data;

import java.util.List;

@Data
public class HdfsResource extends Resource {
  String path;
  Boolean recursive;
  List<String> policys;
}
