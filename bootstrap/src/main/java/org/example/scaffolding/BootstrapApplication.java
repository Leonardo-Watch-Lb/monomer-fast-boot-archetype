package org.example.scaffolding;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.scaffolding.infrastructure.helper.PropertyHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;

/**
 * @author Administrator
 */
@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy
public class BootstrapApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(BootstrapApplication.class, args);
        log.info("Application Start SUCCESS!!!");
        log.info("测试地址: http://localhost:{}/{}/echo/hello", PropertyHolder.getProperty("server.port"),
                StringUtils.replace(PropertyHolder.getProperty("server.servlet.context-path"), "/", "")
        );
    }

}
