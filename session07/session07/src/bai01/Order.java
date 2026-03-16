package bai01;

import java.util.List;
import java.util.Map;

public class Order {
    private String orderId;
    private Customer customer;
    private Map<Product, Integer> products;

    public Order(String orderId, Customer customer, Map<Product, Integer> products) {
        this.orderId = orderId;
        this.customer = customer;
        this.products = products;
    }

    public Order() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
