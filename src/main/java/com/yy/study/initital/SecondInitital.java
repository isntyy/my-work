package com.yy.study.initital;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;

/**
 * @author wyy
 * @since 2020-07-06 21:27
 */
@Order(2)
public class SecondInitital implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        HashMap<String, Object> map = new HashMap<>();
        map.put("key2","value2");
        MapPropertySource source = new MapPropertySource("SecondInitital",map);
        environment.getPropertySources().addLast(source);
        System.out.println("===>>> SecondInitital");
    }
}
