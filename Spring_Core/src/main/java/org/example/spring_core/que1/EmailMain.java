package org.example.spring_core.que1;
//Implement a Lightweight IoC
public class EmailMain {
    public static void main(String[] args) {
        Injector injector=new Injector();
        injector.register(Service.class,new EmailService());

        Service s=injector.getInstance(Service.class);
        System.out.println("Injected "+s.getClass().getSimpleName());
    }
}
