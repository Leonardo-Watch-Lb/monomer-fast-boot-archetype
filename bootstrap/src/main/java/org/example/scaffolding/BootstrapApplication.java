package org.example.scaffolding;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.scaffolding.helper.PropertiesHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Administrator
 */
@SpringBootApplication
@EnableAspectJAutoProxy
@Slf4j
public class BootstrapApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
        log.info("Application Start SUCCESS!!!");
        log.info("测试地址: http://localhost:{}/{}/echo/hello", PropertiesHelper.getProperty("server.port"),
                StringUtils.replace(PropertiesHelper.getProperty("server.servlet.context-path"), "/", "")
        );
    }

}
