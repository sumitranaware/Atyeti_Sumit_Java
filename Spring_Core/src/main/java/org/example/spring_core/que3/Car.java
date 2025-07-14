package org.example.spring_core.que3;
@MyComponent
public class Car {
    @MyAutowired
    private Engine engine;

    public void drive(){
        engine.start();
        System.out.println("Car is driving");
    }
}
