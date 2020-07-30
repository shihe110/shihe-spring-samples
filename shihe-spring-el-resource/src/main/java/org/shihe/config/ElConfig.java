package org.shihe.config;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;


/**
 * @ClassName ElConfig
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 16:48
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "org.shihe")
@PropertySource("test.properties")
public class ElConfig {
    @Value("I Love You!")
    private String normal;
    @Value("#{systemProperties['os.name']}")
    private String osName;
    @Value("#{systemEnvironment['os.arch']}")
    private String osArch;
    @Value("#{T(java.lang.Math).random()*100}")
    private double randomNumber;
    @Value("#{demoService.name}")
    private String author;
    @Value("test.txt")
    private Resource testFile;

    @Value("http://www.baidu.com")
    private Resource testUrl;
    @Value("${shihe.name}")
    private String su;
    @Value("${shihe.age}")
    private Integer sp;

    @Autowired
    private Environment environment;

    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(osArch);
            System.out.println(randomNumber);
            System.out.println(author);
            System.out.println(IOUtils.toString(testFile.getInputStream(),"UTF-8"));
            //访问网址
            System.out.println(IOUtils.toString(testUrl.getInputStream(),"UTF-8"));
            //获取网址
            System.out.println("testUrl.getURL():"+testUrl.getURL());
            System.out.println(su);
            System.out.println(sp);
            System.out.println(environment.getProperty("shihe.name"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
