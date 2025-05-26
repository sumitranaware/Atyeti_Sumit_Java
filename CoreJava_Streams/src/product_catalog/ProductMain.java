package product_catalog;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ProductMain {
    public static void main(String[] args) {
        List<Product> product = Arrays.asList(
                new Product("Laptop", "Electronics", 120000),
                new Product("Phone", "Electronics", 55000),
                new Product("Table", "Furniture", 68990),
                new Product("Sofa", "Furniture", 890000),
                new Product("Headphones", "Electronics", 15000)
        );

        // Filtering the products
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Category");
        String category = sc.nextLine().trim();
        Predicate<Product> getCategory = p -> p.getCategory().equalsIgnoreCase(category);
        List<Product> filterList = product.stream()
                .filter(getCategory)
                .toList();
        filterList.forEach(System.out::println);

        sc.close();


        // Sorting Product by price
        List<Product> sortedByPrice = product.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .toList();

        sortedByPrice.forEach(System.out::println);

        // Consumer for display the product
        Consumer<Product> displayProduct = System.out::println;

        product.forEach(displayProduct);

        // Supplier to provide Default product

        Supplier<Product>defaultProduct=()->new Product("Default","None",0.0);

        Product product1=defaultProduct.get();
        System.out.println(product1);

    }
}
