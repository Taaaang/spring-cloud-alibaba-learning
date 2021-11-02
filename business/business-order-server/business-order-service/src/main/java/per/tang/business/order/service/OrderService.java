package per.tang.business.order.service;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import per.tang.business.order.api.IOrderService;
import per.tang.business.order.api.entity.Order;
import pers.tang.business.user.api.IUserService;
import pers.tang.business.user.api.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service(version = "${provider.order.service.version}")
@RefreshScope
@Component
public class OrderService implements IOrderService {


    @Reference(version = "${consumer.user.service.version}")
    private IUserService userService;

    public Order getOrder(Long orderId) {
        Order order;
        try (Entry entry = SphU.entry("getOrder")){
            Assert.notNull(orderId,"orderId is null!");
            Assert.isTrue(orderId>0,"order less than 0!");
            System.out.println("查询订单请求！");
            //获取用户信息
            User user = userService.getUser(1);
            //构建订单
            order=new Order(orderId,"订单名称:"+orderId,user);
            System.out.println("订单获取完毕！订单信息==>"+order.toString());
        } catch (BlockException e) {
            throw new RuntimeException("getOrder()已达到访问限制!!!");
        }
        return order;
    }

    @Value("${test}")
    private String test;

    public String testRemoteConfig() {

        return test;
    }



}
