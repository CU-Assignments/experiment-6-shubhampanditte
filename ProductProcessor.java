import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " ($" + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        // Sample dataset of products
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Smartphone", "Electronics", 800),
            new Product("TV", "Electronics", 1500),
            new Product("Sofa", "Furniture", 700),
            new Product("Table", "Furniture", 300),
            new Product("Chair", "Furniture", 200),
            new Product("Refrigerator", "Appliances", 1000),
            new Product("Washing Machine", "Appliances", 900),
            new Product("Microwave", "Appliances", 400),
            new Product("Air Conditioner", "Appliances", 1300)
        );

        // 1. Grouping products by category
        Map<String, List<Product>> productsByCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> 
            System.out.println(category + ": " + productList));

        // 2. Finding the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                Product::getCategory, 
                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
            ));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, product) -> 
            System.out.println(category + " -> " + product.orElse(null)));

        // 3. Calculating the average price of all products
        double averagePrice = products.stream()
            .mapToDouble(Product::getPrice)
            .average()
            .orElse(0);

        System.out.println("\nAverage price of all products: $" + averagePrice);
    }
}
