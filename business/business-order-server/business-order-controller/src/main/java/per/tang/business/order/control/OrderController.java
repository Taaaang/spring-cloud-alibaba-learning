package per.tang.business.order.control;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import per.tang.business.order.api.IOrderService;
import per.tang.business.order.api.entity.Order;

@RestController
@RequestMapping("order")
public class OrderController {

    @Reference(version = "1.0.0",check = false)
    public IOrderService orderService;

    @RequestMapping("queryOrder/{orderId}")
    @SentinelResource("queryOrderTest")
    public Order queryOrder(@PathVariable(name = "orderId") Long orderId){
        return orderService.getOrder(orderId);
    }

    @RequestMapping("get")
    public void get(@RequestBody TestInfo testInfo){

    }

    @RequestMapping("test")
    public String testNacosConfig(){
        return orderService.testRemoteConfig();
    }



    public static class TestInfo{
        private String name;
        private Integer age;
    }
}
