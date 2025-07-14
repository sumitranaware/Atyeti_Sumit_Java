package org.example.spring_core.que2;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String name){
        System.out.println("Before init "+name);
        return bean;
    }
    public Object postProcessAfterInitialization(Object bean, String name){
        System.out.println("After Init:"+name);
        return bean;
    }
}
