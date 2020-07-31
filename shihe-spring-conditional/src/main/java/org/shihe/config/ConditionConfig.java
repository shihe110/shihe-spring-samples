package org.shihe.config;

import org.shihe.condition.LinuxCondition;
import org.shihe.condition.WindowsCondition;
import org.shihe.os.LinuxListService;
import org.shihe.os.WindowsListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName ConditionConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 15:11
 * @Version 1.0
 */
@Configuration
public class ConditionConfig {
    @Bean
    @Conditional(WindowsCondition.class)
    WindowsListService windowsListService(){
        return new WindowsListService();
    }

    @Bean
    @Conditional(LinuxCondition.class)
    LinuxListService linuxListService(){
        return new LinuxListService();
    }
}
