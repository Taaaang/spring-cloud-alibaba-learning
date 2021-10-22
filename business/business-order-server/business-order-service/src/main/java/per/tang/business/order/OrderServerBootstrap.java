package per.tang.business.order;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableDubbo(scanBasePackages = "per.tang.business.order.service")
public class OrderServerBootstrap {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(OrderServerBootstrap.class);
    }

}
