package per.tang.business.order.config;

import com.alibaba.csp.sentinel.cluster.flow.rule.ClusterFlowRuleManager;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.property.SentinelProperty;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Properties;

/**
 * @Author:TangFenQi
 * @Date:2021/11/14 14:32
 **/
@Component
public class NacosStarter implements SmartInitializingSingleton {

    @Autowired
    private Gson gson;
    @Autowired
    private NacosFlowRuleConfiguration flowRuleConfiguration;
    @Autowired
    private NacosDegradeRuleConfiguration degradeRuleConfiguration;
    @Override
    public void afterSingletonsInstantiated() {
        Properties properties=new Properties();
        properties.setProperty(PropertyKeyConst.SERVER_ADDR,flowRuleConfiguration.getServeraddr());
        properties.setProperty(PropertyKeyConst.NAMESPACE,flowRuleConfiguration.getNamespace());
        //flowRule
        ClusterFlowRuleManager.setPropertySupplier
                (namespace-> new NacosDataSource<>(properties, flowRuleConfiguration.getGroupId(), flowRuleConfiguration.getDataId()
                        , (Converter<String, List<FlowRule>>) s -> gson.fromJson(s, new TypeToken<List<FlowRule>>() {
                }.getType())).getProperty());

        //degradeRule
         SentinelProperty<List<DegradeRule>> degradeProperty = new NacosDataSource<>(properties, degradeRuleConfiguration.getGroupId(), degradeRuleConfiguration.getDataId()
                , (Converter<String, List<DegradeRule>>) s -> gson.fromJson(s, new TypeToken<List<DegradeRule>>() {
        }.getType())).getProperty();
        DegradeRuleManager.register2Property(degradeProperty);
    }
}
