package per.tang.business.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @Author:TangFenQi
 * @Date:2021/11/14 13:08
 **/
@Component
@ConfigurationProperties(prefix = "spring.cloud.sentinel.datasource.degrade.nacos")
@RefreshScope
@Data
public class NacosDegradeRuleConfiguration {


    private String serveraddr;//nacos的地址
    private String dataId;
    private String groupId="SENTINEL_CONFIG";//nacos上的分组信息
    private String namespace="dev";//nacos上的命名空间，指定某个环境

}
