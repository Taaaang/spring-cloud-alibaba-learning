package per.tang.business.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import java.io.IOException;

@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
public class OrderControlApplication{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //springweb
        SpringApplication.run(OrderControlApplication.class);
    }

    @org.springframework.context.annotation.Bean //必须new 一个RestTemplate并放入spring容器当中,否则启动时报错
    @LoadBalanced
    public org.springframework.web.client.RestTemplate restTemplate() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(30 * 1000);
        httpRequestFactory.setConnectTimeout(30 * 3000);
        httpRequestFactory.setReadTimeout(30 * 3000);
        return new org.springframework.web.client.RestTemplate(httpRequestFactory);
    }

}
