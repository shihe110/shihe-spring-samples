package org.shihe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @ClassName DemoCofig
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 16:49
 * @Version 1.0
 */
@Configuration
public class DemoCofig {

    @Bean
    @Profile("dev")
    DemoBean demoBeanDev(){
        return new DemoBean("dev");
    }

    @Bean
    @Profile("pro")
    DemoBean demoBeanPro(){
        return new DemoBean("pro");
    }
}
