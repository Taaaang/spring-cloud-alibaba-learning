package per.tang.business.order;

import com.alibaba.csp.sentinel.cluster.ClusterStateManager;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientAssignConfig;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientConfigManager;
import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterFlowRuleManager;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.property.DynamicSentinelProperty;
import com.alibaba.csp.sentinel.property.SentinelProperty;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.util.function.Function;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties
@EnableDiscoveryClient
@EnableDubbo(scanBasePackages = "per.tang.business.order.service")
public class OrderServerBootstrap {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OrderServerBootstrap.class);


        //initSentinelClientConfiguration();
    }

    @Bean
    public Gson buildGson(){
        return new Gson();
    }

    public static void initSentinelClientConfiguration(){
        //设置当前service为sentinel的客户端
        ClusterStateManager.applyState(ClusterStateManager.CLUSTER_CLIENT);
        ClusterClientAssignConfig config=new ClusterClientAssignConfig();
        DynamicSentinelProperty<ClusterClientAssignConfig> property = new DynamicSentinelProperty<>(config);
        config.setServerHost("localhost");
        config.setServerPort(33333);
        ClusterClientConfigManager.registerServerAssignProperty(property);
    }

}
