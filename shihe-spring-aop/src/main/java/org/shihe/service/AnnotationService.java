package org.shihe.service;


import org.springframework.stereotype.Service;

@Service
public class AnnotationService {

    public void hello(){
        System.out.println("service 调用");
    }
}
