package org.example.spring_core.que1;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Injector implements Service {
    private Map<Class<?>, Object>registry=new HashMap<>();
    public <T>void register(Class<T> type,T instance){
        registry.put(type,instance);
    }
    public <T> T getInstance(Class<T>type){
        return type.cast(registry.get(type));
    }
}
