package org.shihe.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SpringApiServcie {

    @Autowired
    private DemoSpringApiService demoSpringApiService;

    public void hello(){
        System.out.println("==============");
        demoSpringApiService.springApi();
        System.out.println("-----------------");
    }
}
