package pers.tang.business.user.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;
    private String name;
    private Integer age;

    @Override
    public String toString(){
        return String.format("用户编号:%s,用户姓名:%s",id,name);
    }
}
