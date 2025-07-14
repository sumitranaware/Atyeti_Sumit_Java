package org.example.spring_core.que2;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class MyBean {
    @PostConstruct
    public void init(){
        System.out.println("Post Construct-init called");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("PreDestroy-cleanup");
    }
}
