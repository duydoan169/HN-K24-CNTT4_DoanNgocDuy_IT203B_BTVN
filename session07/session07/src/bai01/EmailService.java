package bai01;

public class EmailService {

    public static void sendOrderConfirmation(Order order) {
        System.out.println(
                "Đã gửi email đến " + order.getCustomer().getEmail()
                        + ": Đơn hàng " + order.getOrderId() + " đã được tạo"
        );
    }
}