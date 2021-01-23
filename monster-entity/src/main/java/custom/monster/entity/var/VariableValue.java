package custom.monster.entity.var;


import custom.monster.entity.plugin.ParamType;

public interface VariableValue {

  public VariableType getVariableType();

  public Object getValue();

  public void setValue(Object valueString);

  public ParamType getParamType();

  public void applyUpdate(Object value);

}
