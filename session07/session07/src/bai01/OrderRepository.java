package bai01;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();

    // Lưu đơn hàng
    public void save(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.getOrderId());
    }

    // Lấy tất cả đơn hàng
    public List<Order> findAll() {
        return new ArrayList<>(orders); // tránh sửa trực tiếp dữ liệu
    }

    // Tìm đơn hàng theo orderId
    public Order findById(String orderId) {
        for (Order order : orders) {
            if (order.getOrderId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    // Kiểm tra đơn hàng có tồn tại không
    public boolean existsById(String orderId) {
        return findById(orderId) != null;
    }

    // Xóa đơn hàng theo ID
    public boolean deleteById(String orderId) {
        return orders.removeIf(o -> o.getOrderId().equals(orderId));
    }

    // Số lượng đơn hàng
    public int count() {
        return orders.size();
    }
}