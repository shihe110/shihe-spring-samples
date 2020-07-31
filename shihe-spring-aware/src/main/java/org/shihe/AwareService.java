package org.shihe;

import com.sun.deploy.net.cookie.CookieUnavailableException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName AwareService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-31 11:26
 * @Version 1.0
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;

    private ResourceLoader resourceLoader;

    public void setBeanName(String s) {
        this.beanName = s;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public void outputResult(){
        System.out.println("bean的名称为"+beanName);

        Resource resource = resourceLoader.getResource("test.txt");
        try {
            InputStream inputStream = resource.getInputStream();
            System.out.println("文件内容为： "+IOUtils.toString(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
