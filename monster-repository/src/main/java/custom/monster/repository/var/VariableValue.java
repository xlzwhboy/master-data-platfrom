package custom.monster.repository.var;


import custom.monster.repository.plugin.ParamType;

public interface VariableValue {

  public VariableType getVariableType();

  public Object getValue();

  public void setValue(Object valueString);

  public ParamType getParamType();

  public void applyUpdate(Object value);

}
