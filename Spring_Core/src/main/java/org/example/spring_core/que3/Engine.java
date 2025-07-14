package org.example.spring_core.que3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyComponent
public class Engine {
    public void start(){
        System.out.println("Engine started..");
    }
}
