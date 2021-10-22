package per.tang.business.order.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import pers.tang.business.user.api.entity.User;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Order implements Serializable {

    private Long orderId;

    private String name;

    private User user;

    @Override
    public String toString(){
        return String.format("订单编号:%s,订单名称:%s",orderId,name);
    }

}
