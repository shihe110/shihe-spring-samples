package org.shihe.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName AopConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 15:44
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "org.shihe")
@EnableAspectJAutoProxy // 开启对aspectj代理的支持
public class AopConfig {

}
