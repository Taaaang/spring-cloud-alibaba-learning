package per.tang.business.order.config;

import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterFlowRuleManager;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

/**
 * @Author:TangFenQi
 * @Date:2021/11/14 13:08
 **/
@Component
@ConfigurationProperties(prefix = "spring.cloud.sentinel.datasource.flow.nacos")
@RefreshScope
@Data
public class NacosFlowRuleConfiguration {


    private String serveraddr;//nacos的地址
    private String dataId;
    private String groupId="SENTINEL_CONFIG";//nacos上的分组信息
    private String namespace="dev";//nacos上的命名空间，指定某个环境

}
