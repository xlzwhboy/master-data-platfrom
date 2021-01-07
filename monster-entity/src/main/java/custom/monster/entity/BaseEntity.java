package custom.monster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass  //此注解下的类不会被映射到数据库上,但是继承他的子类,会添加相应的属性到对应的数据库表中
public class BaseEntity {
    @JsonIgnore //生成json 时不生成isTrash的属性
    private boolean isTrash = false;  //是不是脏数据
    private int createTime;
}
