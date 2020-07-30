package org.shihe.config;

import org.shihe.bean.DemoBeanService;
import org.shihe.jsr250.DemoJSR250Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DemoInitDesConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 17:36
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "org.shihe")
public class DemoInitDesConfig {

    @Bean(initMethod = "init",destroyMethod = "destroy")
    DemoBeanService demoBeanService(){
        return new DemoBeanService();
    }

    @Bean
    DemoJSR250Service demoJSR250Service(){
        return new DemoJSR250Service();
    }
}

