package org.shihe.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName DemoService
 * @Description TODO
 * @Author admin
 * @Date 2020-07-30 16:47
 * @Version 1.0
 */
@Service
public class DemoService {

    @Value("其他类的属性")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
