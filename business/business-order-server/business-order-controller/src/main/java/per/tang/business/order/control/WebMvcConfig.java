package per.tang.business.order.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:TangFenQi
 * @Date:2021/11/15 12:27
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private TestInterceptor testInterceptor;

    /**
     * 注册拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * addInterceptor 注册拦截器
         * addPathPatterns 配置拦截规则
         */
        registry.addInterceptor(testInterceptor)
                .addPathPatterns("/**");
    }
}
