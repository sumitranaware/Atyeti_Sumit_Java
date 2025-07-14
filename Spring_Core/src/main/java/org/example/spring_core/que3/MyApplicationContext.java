package org.example.spring_core.que3;

import jakarta.websocket.OnClose;

import java.beans.FeatureDescriptor;
import java.lang.reflect.Field;
import java.util.*;

public class MyApplicationContext {
    private Map<Class<?>, Object>container=new HashMap<>();
    public void intialize(String basePackage)throws Exception{
        Set<Class<?>>classes=scanClasses(basePackage);
        for (Class<?>cla:classes){
            if (cla.isAnnotationPresent(MyComponent.class)){
                Object instance=cla.getDeclaredConstructor().newInstance();
                container.put(cla,instance);
            }
        }
        for (Object bean: container.values()){
            for (Field field:bean.getClass().getDeclaredFields()){
               if (field.isAnnotationPresent(MyAutowired.class)){
                   field.setAccessible(true);
                   Object dependency=container.get(field.getType());
                   field.set(bean,dependency);
               }
            }
        }
    }

  public <T>T getBean(Class<T>cla){
        return cla.cast(container.get(cla));
  }
  private Set<Class<?>>scanClasses(String basePackage) throws Exception{
        return Set.of(Car.class,Engine.class);
  }
}
