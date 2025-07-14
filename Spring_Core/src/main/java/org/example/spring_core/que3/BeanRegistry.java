package org.example.spring_core.que3;

public class BeanRegistry {
    public static void main(String[] args) {
        MyApplicationContext context =new MyApplicationContext();
        try {
            context.intialize("your.package.name");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Car car=context.getBean(Car.class);
        car.drive();
    }
}
