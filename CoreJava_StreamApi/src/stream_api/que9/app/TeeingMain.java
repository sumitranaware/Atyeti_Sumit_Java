package stream_api.que9.app;

import stream_api.que9.model.DashboardStats;
import stream_api.que9.model.Product;

import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TeeingMain {
    public static void main(String[] args) {
        List<Product>products=List.of(
                new Product("Phone",50000),
                new Product("Laptop",90000),
                new Product("Airpods",4000),
                new Product("Watch",3000)
        );

        DashboardStats stats = products.stream()
                .collect(Collectors.teeing(
                        Collectors.counting(),
                        Collectors.averagingDouble(Product::getPrice),
                        DashboardStats::new
                ));

        System.out.println("Dashboard Stats:");
        System.out.println("Total Products: " + stats.getCount());
        System.out.println("Average Price: " + stats.getAveragePrice());
    }
}
