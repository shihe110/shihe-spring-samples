package org.shihe.env.config;

import org.shihe.env.bean.DemoBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ClassName ProfileConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 18:00
 * @Version 1.0
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    DemoBean demoBeanDev(){
        DemoBean dev = new DemoBean("dev");
        return dev;
    }

    @Bean
    @Profile("pro")
    DemoBean demoBeanPro(){
        DemoBean pro = new DemoBean("pro");
        return pro;
    }
}
