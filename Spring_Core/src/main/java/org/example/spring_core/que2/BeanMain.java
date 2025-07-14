package org.example.spring_core.que2;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class BeanMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(BeanMain.class,args);
        context.close();
    }
}
