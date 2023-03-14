package org.example.scaffolding;

import lombok.extern.slf4j.Slf4j;
import org.example.scaffolding.infrastructure.helper.PropertyHolder;
import org.example.scaffolding.infrastructure.utils.StringUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author Administrator
 */
@Slf4j
@SpringBootApplication
@EnableAspectJAutoProxy
public class BootstrapApplication implements CommandLineRunner {

    /**
     * 主启动类
     */
    public static void main(String[] args) {
        SpringApplication.run(BootstrapApplication.class, args);
    }

    /**
     * 启动后动作
     */
    @Override
    public void run(String... args) throws Exception {
        String port = PropertyHolder.getProperty("server.port");
        String contextPath = PropertyHolder.getProperty("server.servlet.context-path");
        String serverPath = String.format("http://localhost:%s%s/", port, StringUtil.optimisticUri(contextPath));
        log.info("应用启动成功!");
        log.info("Echo 测试地址: {}echo/hello", serverPath);
        log.info("Swagger 地址: {}swagger-ui/index.html", serverPath);
    }

}
