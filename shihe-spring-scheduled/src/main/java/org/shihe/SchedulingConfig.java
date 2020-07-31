package org.shihe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName SchedulingConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 14:31
 * @Version 1.0
 */
@Configuration
@EnableScheduling // 开启计划任务
@ComponentScan(basePackages = "org.shihe")
public class SchedulingConfig {
}
