package bai01;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();

    public void save(Customer customer) {
        customers.add(customer);
        System.out.println("Đã thêm khách hàng");
    }

    public Customer findByEmail(String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers);
    }
}