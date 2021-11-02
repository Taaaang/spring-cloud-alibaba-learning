package per.tang.business.order.control;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.tang.business.order.api.IOrderService;
import per.tang.business.order.api.entity.Order;

@RestController
@RequestMapping("order")
@Component
public class OrderController {

    @Reference(version = "1.0.0")
    public IOrderService orderService;

    @RequestMapping("queryOrder/{orderId}")
    public Order queryOrder(@PathVariable(name = "orderId") Long orderId){
        return orderService.getOrder(orderId);
    }

    @RequestMapping("test")
    public String testNacosConfig(){
        return orderService.testRemoteConfig();
    }

}
