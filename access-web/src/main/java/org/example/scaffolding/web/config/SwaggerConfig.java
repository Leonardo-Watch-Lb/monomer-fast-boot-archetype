package org.example.scaffolding.web.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.servlet.mvc.method.RequestMappingInfoHandlerMapping;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.spring.web.plugins.WebFluxRequestHandlerProvider;
import springfox.documentation.spring.web.plugins.WebMvcRequestHandlerProvider;

import java.lang.reflect.Field;
import java.util.List;

/**
 * @author Leonardo
 * @creatTime 2023/3/14 22:00
 * Swagger 配置类
 */
@Configuration
public class SwaggerConfig {

    /**
     * 兼容swagger配置
     */
    @Bean
    public BeanPostProcessor springfoxHandlerProviderBeanPostProcessor() {
        return new BeanPostProcessor() {
            @Override
            @SuppressWarnings({"NullableProblems", "unchecked"})
            public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                if (bean instanceof WebMvcRequestHandlerProvider || bean instanceof WebFluxRequestHandlerProvider) {
                    try {
                        Field field = ReflectionUtils.findField(bean.getClass(), "handlerMappings");
                        if (null != field) {
                            field.setAccessible(true);
                            List<RequestMappingInfoHandlerMapping> mappings = (List<RequestMappingInfoHandlerMapping>) field.get(bean);
                            mappings.removeIf(e -> null != e.getPatternParser());
                        }
                    } catch (IllegalArgumentException | IllegalAccessException e) {
                        throw new IllegalStateException(e);
                    }
                }
                return bean;
            }
        };
    }

    /**
     * swagger 配置
     */
    @Bean
    public Docket swaggerApi(){
        Docket docket = new Docket(DocumentationType.OAS_30);
        docket.apiInfo(new ApiInfoBuilder()
                               .title("快速搭建单体架构")
                               .license("APACHE LICENSE 2.0")
                               .build());
        return docket;
    }
}
