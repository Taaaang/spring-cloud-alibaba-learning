package per.tang.business.user;

import com.alibaba.csp.sentinel.cluster.ClusterStateManager;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientAssignConfig;
import com.alibaba.csp.sentinel.cluster.client.config.ClusterClientConfigManager;
import com.alibaba.csp.sentinel.property.DynamicSentinelProperty;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication
@EnableDubbo(scanBasePackages = "per.tang.business.user.service")
@EnableDiscoveryClient
public class UserServerBootstrap {

    public static void main(String[] args) throws IOException {
        //initSentinelClientConfiguration();
        SpringApplication.run(UserServerBootstrap.class);
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
