package custom.monster.repository.plugin;

import lombok.Data;

@Data
public class PackageParam {

  private String name;
  private String description;
  private boolean required = true;
  private String defaultValue;
  private boolean userSetAble = true;
  private ParamType type;
  private ParamEntityType entityType = ParamEntityType.PLAIN;
  private String example;

}
