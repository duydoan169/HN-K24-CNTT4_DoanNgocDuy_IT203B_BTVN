package bai01;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ProductRepository products = new ProductRepository();
        CustomerRepository customers = new CustomerRepository();
        OrderRepository orders = new OrderRepository();
        products.save(new Product("SP01", "laptop", 15000000));
        products.save(new Product("SP02", "Chuot", 300000));

        Customer customer = new Customer("Nguyễn Văn A", "a@example.com", "Ha Noi");
        customers.save(customer);

        Map<Product, Integer> map = new HashMap<>();
        map.put(products.findById("SP01"), 1);
        map.put(products.findById("SP02"), 2);
        Order order = new Order("ORD001", customer, map);
        System.out.println("Tổng tiền: " + OrderCalculator.calculateTotal(order));

        orders.save(order);

        EmailService.sendOrderConfirmation(order);
    }
}
