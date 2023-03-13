package org.example.scaffolding.helper;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author Leonardo
 * @creatTime 2023/3/13 20:45
 */
@Component
public class PropertiesHelper implements EnvironmentAware {

    /**
     * 环境
     */
    private static Environment environment;

    /**
     * 获取环境参数
     * @param key
     * @return
     */
    public static String getProperty(String key){
        return PropertiesHelper.environment.getProperty(key);
    }

    /**
     * 设置方法
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        PropertiesHelper.environment = environment;
    }

}
