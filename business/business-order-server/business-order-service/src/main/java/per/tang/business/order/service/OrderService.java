package per.tang.business.order.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import per.tang.business.order.api.IOrderService;
import per.tang.business.order.api.entity.Order;
import pers.tang.business.user.api.IUserService;
import pers.tang.business.user.api.entity.User;

@Service(version = "${provider.order.service.version}")
@RefreshScope
@Component
public class OrderService implements IOrderService {


    @Reference(version = "${consumer.user.service.version}")
    private IUserService userService;

    public Order getOrder(Long orderId) {
        Assert.notNull(orderId,"orderId is null!");
        Assert.isTrue(orderId>0,"order less than 0!");
        System.out.println("查询订单请求！");
        //获取用户信息
        User user = userService.getUser(1);
        //构建订单
        Order order=new Order(orderId,"订单名称:"+orderId,user);
        System.out.println("订单获取完毕！订单信息==>"+order.toString());
        return order;
    }

    @Value("${test}")
    private String test;

    public String testRemoteConfig() {

        return test;
    }
}